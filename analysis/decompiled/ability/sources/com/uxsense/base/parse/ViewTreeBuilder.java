package com.uxsense.base.parse;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uxsense.core.base.parse.KRect;
import com.uxsense.core.base.parse.KViewNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class ViewTreeBuilder {
    private static final Pattern ID_PATTERN = Pattern.compile("app:id/(\\w+)");

    public static final class BuildResult {
        private final Map<Long, View> index;
        private final KViewNode rootNode;

        public BuildResult(@NonNull KViewNode kViewNode, @NonNull Map<Long, View> map) {
            this.rootNode = kViewNode;
            this.index = map;
        }

        @Nullable
        public View findView(long j5) {
            return this.index.get(Long.valueOf(j5));
        }

        @NonNull
        public KViewNode getRootNode() {
            return this.rootNode;
        }

        public int size() {
            return this.index.size();
        }
    }

    private ViewTreeBuilder() {
    }

    @NonNull
    public static BuildResult build(@NonNull View view) {
        HashMap map = new HashMap();
        return new BuildResult(buildRecursive(view, -1, map), map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static KViewNode buildRecursive(@NonNull View view, int i, @NonNull Map<Long, View> map) {
        String str;
        String string;
        int max;
        int i6;
        int min;
        boolean z10;
        boolean z11;
        String name = view.getClass().getName();
        String string2 = null;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            CharSequence text = textView.getText();
            String string3 = (text == null || text.length() <= 0) ? null : text.toString();
            CharSequence hint = textView.getHint();
            string = (hint == null || hint.length() <= 0) ? null : hint.toString();
            str = string3;
        } else {
            str = null;
            string = null;
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null && contentDescription.length() > 0) {
            string2 = contentDescription.toString();
        }
        String str2 = string2;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        boolean z12 = true;
        KRect kRect = new KRect(i10, iArr[1], view.getWidth() + i10, view.getHeight() + iArr[1]);
        String strExtractId = extractId(view.toString());
        boolean z13 = view.isClickable() || view.isFocusable() || view.isLongClickable();
        boolean zIsLongClickable = view.isLongClickable();
        boolean z14 = view instanceof Checkable;
        boolean z15 = z14 && ((Checkable) view).isChecked();
        if (view instanceof SeekBar) {
            SeekBar seekBar = (SeekBar) view;
            int progress = seekBar.getProgress();
            max = seekBar.getMax();
            min = seekBar.getMin();
            i6 = progress;
        } else {
            max = 100;
            i6 = 0;
            min = 0;
        }
        int i11 = max;
        boolean z16 = view instanceof ViewGroup;
        if (z16) {
            ViewGroup viewGroup = (ViewGroup) view;
            boolean z17 = viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1);
            if (!viewGroup.canScrollHorizontally(1) && !viewGroup.canScrollHorizontally(-1)) {
                z12 = false;
            }
            z10 = z12;
            z11 = z17;
        } else {
            z10 = false;
            z11 = false;
        }
        ArrayList arrayList = new ArrayList();
        if (z16) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int i12 = 0;
            while (i12 < viewGroup2.getChildCount()) {
                View childAt = viewGroup2.getChildAt(i12);
                boolean z18 = z14;
                if (childAt.getVisibility() != 8) {
                    arrayList.add(buildRecursive(childAt, i12, map));
                }
                i12++;
                z14 = z18;
            }
        }
        long jHashCode = view.hashCode();
        KViewNode kViewNode = new KViewNode(i, jHashCode, name, strExtractId, kRect, str2, str, string, arrayList, z13, zIsLongClickable, false, z10, z11, z14, z15, i6, i11, min);
        map.put(Long.valueOf(jHashCode), view);
        return kViewNode;
    }

    @Nullable
    private static String extractId(String str) {
        Matcher matcher = ID_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}

package com.android.ttcjpaysdk.base.ui.component.pop;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.framework.container.drawable.CJPayStdSweepingDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keepSrcInTheme", "needSweep", "", "srcId", "useSweep", "", "isNeedSweep", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJImageView extends AppCompatImageView {
    public static final Companion Companion = null;
    private static final int KEEP_LIGHT_MODE = 2;
    private static final int KEEP_NIGHT_MODE = 1;
    private static final int KEEP_NO = 0;
    private static final String XMLNS_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String XMLNS_APP = "http://schemas.android.com/apk/res-auto";
    private int keepSrcInTheme;
    private boolean needSweep;
    private int srcId;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/component/pop/CJImageView$Companion;", "", "()V", "KEEP_LIGHT_MODE", "", "KEEP_NIGHT_MODE", "KEEP_NO", "XMLNS_ANDROID", "", "XMLNS_APP", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void useSweep(boolean r100) {
        this.needSweep = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        setForeground(new CJPayStdSweepingDrawable());
        return;
    }

    public CJImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (r101 == null) goto L15;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.keepSrcInTheme});
        this.keepSrcInTheme = r103.getInt(0, 0);
        r103.recycle();
        int r104 = r101.getAttributeResourceValue(XMLNS_APP, "srcCompat", 0);
        this.srcId = r104;
        if (r104 != 0) goto L7;
        this.srcId = r101.getAttributeResourceValue(XMLNS_ANDROID, "src", 0);
    L7:
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.needSweep});
        int r106 = r105.getIndexCount();
        if (r106 < 0) goto L15;
        int r107 = 0;
    L10:
        int r108 = r105.getIndex(r107);
        if (r108 != 0) goto L13;
        useSweep(r105.getBoolean(r108, false));
    L13:
        if (r107 == r106) goto L15;
        r107 = r107 + 1;
    L15:
        int r109 = this.srcId;
        if (r109 <= 0) goto L26;
        int r110 = this.keepSrcInTheme;
        if (r110 != 1) goto L20;
        setImageDrawable(ContextCompat.getDrawable(r100, r109));
        return;
    L20:
        if (r110 != 2) goto L28;
        setImageDrawable(ContextCompat.getDrawable(r100, r109));
        return;
    L28:
        return;
    }

    public /* synthetic */ CJImageView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}

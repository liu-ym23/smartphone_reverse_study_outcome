package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f133651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133652b = 0;

    public static final class a extends Spannable.Factory {
        public a() {
        }

        @Override // android.text.Spannable.Factory
        public final Spannable newSpannable(CharSequence r100) {
            if ((r100 instanceof Spannable) == true) goto L5;
            CharSequence r101 = null;
        L6:
            Spannable r102 = (Spannable) r101;
            if (r102 == null) goto L9;
            return r102;
        L9:
            return super.newSpannable(r100);
        L5:
            r101 = r100;
            goto L6
        }
    }

    static {
        f133651a = new a();
        f133652b = 1000 / ((Number) PublicScreenABHelper.E.getValue()).intValue();
    }

    public static void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setSpannableFactory(f133651a);
        if ((r100 instanceof NoMoreSpaceTextView) == false) goto L6;
        ((NoMoreSpaceTextView) r100).setAlwaysInvalidateIntervalInMS(f133652b);
        return;
    }

    public static void b(TextView r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "chatSequence");
        if ((!Intrinsics.areEqual(r100.getText(), r101)) == false) goto L6;
        r100.setText(r101, TextView.BufferType.SPANNABLE);
        return;
    }
}

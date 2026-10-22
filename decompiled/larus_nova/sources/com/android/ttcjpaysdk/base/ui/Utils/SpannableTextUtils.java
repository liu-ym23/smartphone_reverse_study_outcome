package com.android.ttcjpaysdk.base.ui.Utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/Utils/SpannableTextUtils;", "", "()V", "getSpannableText", "Landroid/text/SpannableString;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "text", "", "params", "color", "", "start", "end", "cj-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpannableTextUtils {
    public static final SpannableTextUtils INSTANCE = null;

    static {
        INSTANCE = new SpannableTextUtils();
    }

    private SpannableTextUtils() {
    }

    @JvmStatic
    public static final SpannableString getSpannableText(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L11;
        SpannableString r103 = new SpannableString(r101);
        if (r102 == null) goto L16;
        int r104 = StringsKt.indexOf$default(r103.toString(), r102, 0, false, 6, null);     // Catch: Exception -> L13
        if (r104 < 0) goto L17;
        if (r100 == null) goto L18;
        r103.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r100, R.color.cj_pay_color_black_34)), r104, r102.length() + r104, 33);     // Catch: Exception -> L13
        return r103;
    L18:
        return r103;
    L17:
        return r103;
    L20:
        return r103;
    L16:
        return r103;
    L11:
        return null;
    }

    @JvmStatic
    public static final SpannableString getSpannableText(String r100, int r101, int r102) {
        return getSpannableText(r100, r101, r102, ColorProtector.parseColor("#222222"));
    }

    @JvmStatic
    public static final SpannableString getSpannableText(Context r100, String r101, String r102, int r110) {
        Intrinsics.checkNotNullParameter(r102, "params");
        SpannableString r103 = new SpannableString(r101);
        int r104 = StringsKt.indexOf$default(r103.toString(), r102, 0, false, 6, null);     // Catch: Exception -> L7
        if (r104 < 0) goto L6;
        Intrinsics.checkNotNull(r100);     // Catch: Exception -> L7
        r103.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r100, r110)), r104, r102.length() + r104, 33);     // Catch: Exception -> L7
    L6:
        return r103;
    }

    @JvmStatic
    public static final SpannableString getSpannableText(String r100, int r101, int r102, int r103) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        SpannableString r104 = new SpannableString(r100);
        r104.setSpan(new ForegroundColorSpan(r103), r101, r102, 33);     // Catch: Exception -> L9
        return r104;
    L13:
        return r104;
    L7:
        return null;
    }
}

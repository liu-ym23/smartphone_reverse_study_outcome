package com.android.ttcjpaysdk.base.h5.cjjsb.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastConfig;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "text", "", "textResId", "", "topIconResId", "topIconUrl", "", "duration", "customUiConfig", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;", "(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;)V", "getContext", "()Landroid/content/Context;", "getCustomUiConfig", "()Lcom/android/ttcjpaysdk/base/h5/cjjsb/utils/ToastUiConfig;", "getDuration", "()I", "getText", "()Ljava/lang/CharSequence;", "getTextResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopIconResId", "getTopIconUrl", "()Ljava/lang/String;", "isValid", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ToastConfig {
    private final Context context;
    private final ToastUiConfig customUiConfig;
    private final int duration;
    private final CharSequence text;
    private final Integer textResId;
    private final Integer topIconResId;
    private final String topIconUrl;

    public boolean isValid() {
        CharSequence r100 = this.text;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
    L12:
        return true;
    L11:
        if (this.textResId != null) goto L12;
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final Context getContext() {
        return this.context;
    }

    public final ToastUiConfig getCustomUiConfig() {
        return this.customUiConfig;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final Integer getTextResId() {
        return this.textResId;
    }

    public final Integer getTopIconResId() {
        return this.topIconResId;
    }

    public final String getTopIconUrl() {
        return this.topIconUrl;
    }

    public ToastConfig(Context r100, CharSequence r101, Integer r102, Integer r103, String r104, @SystemToastDuration int r105, ToastUiConfig r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.text = r101;
        this.textResId = r102;
        this.topIconResId = r103;
        this.topIconUrl = r104;
        this.duration = r105;
        this.customUiConfig = r106;
    }

    public /* synthetic */ ToastConfig(Context r100, CharSequence r101, Integer r102, Integer r110, String r111, int r112, ToastUiConfig r113, int r114, DefaultConstructorMarker r115) {
        String r103 = null;
        if ((r114 & 2) == 0) goto L5;
        CharSequence r104 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r114 & 16) != 0) goto L19;
        r103 = r111;
    L19:
        if ((r114 & 32) == 0) goto L21;
        int r107 = 1;
    L23:
        if ((r114 & 64) == 0) goto L25;
        ToastUiConfig r108 = CJToastKt.getDefaultToastUiConfig();
    L26:
        this(r100, r104, r105, r106, r103, r107, r108);
        return;
    L25:
        r108 = r113;
        goto L26
    L21:
        r107 = r112;
        goto L23
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r102;
        goto L11
    L5:
        r104 = r101;
        goto L7
    }
}

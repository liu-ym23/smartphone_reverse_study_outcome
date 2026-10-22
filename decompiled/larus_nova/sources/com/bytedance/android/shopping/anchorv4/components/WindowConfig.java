package com.bytedance.android.shopping.anchorv4.components;

import android.content.Context;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/WindowConfig;", "Ljava/io/Serializable;", "", "forceMute", "Z", "getForceMute", "()Z", "setForceMute", "(Z)V", "existFullModeLiveWindow", "getExistFullModeLiveWindow", "setExistFullModeLiveWindow", "", "previousLiveWindowMargin", "Ljava/lang/Integer;", "getPreviousLiveWindowMargin", "()Ljava/lang/Integer;", "videoPriority", "getVideoPriority", "Lcom/bytedance/android/shopping/anchorv4/components/WindowConfigExtra;", "extraParams", "Lcom/bytedance/android/shopping/anchorv4/components/WindowConfigExtra;", "getExtraParams", "()Lcom/bytedance/android/shopping/anchorv4/components/WindowConfigExtra;", "<init>", "(ZZLjava/lang/Integer;ZLcom/bytedance/android/shopping/anchorv4/components/WindowConfigExtra;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowConfig implements Serializable {
    public static final a Companion = null;
    private boolean existFullModeLiveWindow;
    private final WindowConfigExtra extraParams;
    private boolean forceMute;
    private final Integer previousLiveWindowMargin;
    private final boolean videoPriority;

    public static final class a {
        public a() {
        }

        public static WindowConfig a(Context r100, Boolean r110, String r111, Boolean r112, Boolean r113, Boolean r114) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r110 == null) goto L5;
            boolean r101 = r110.booleanValue();
        L7:
            if (com.bytedance.android.shopping.extensions.k.c(r111) == false) goto L13;
            Boolean r115 = Boolean.TRUE;
            if ((!Intrinsics.areEqual(r113, r115)) == false) goto L13;
            if (Intrinsics.areEqual(r114, r115) == false) goto L13;
            boolean r102 = true;
        L14:
            Integer r103 = null;
            if (r112 == null) goto L17;
            boolean r104 = r112.booleanValue();
        L19:
            return new WindowConfig(r101, r102, r103, r104, null, 16, null);
        L17:
            r104 = true;
        L13:
            r102 = false;
            goto L14
        L5:
            r101 = false;
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public final boolean getExistFullModeLiveWindow() {
        return this.existFullModeLiveWindow;
    }

    public final WindowConfigExtra getExtraParams() {
        return this.extraParams;
    }

    public final boolean getForceMute() {
        return this.forceMute;
    }

    public final Integer getPreviousLiveWindowMargin() {
        return this.previousLiveWindowMargin;
    }

    public final boolean getVideoPriority() {
        return this.videoPriority;
    }

    public final void setExistFullModeLiveWindow(boolean r100) {
        this.existFullModeLiveWindow = r100;
    }

    public final void setForceMute(boolean r100) {
        this.forceMute = r100;
    }

    public WindowConfig(boolean r100, boolean r101, Integer r102, boolean r103, WindowConfigExtra r104) {
        this.forceMute = r100;
        this.existFullModeLiveWindow = r101;
        this.previousLiveWindowMargin = r102;
        this.videoPriority = r103;
        this.extraParams = r104;
    }

    public /* synthetic */ WindowConfig(boolean r100, boolean r101, Integer r110, boolean r111, WindowConfigExtra r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Integer r104 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        WindowConfigExtra r105 = null;
    L18:
        this(r102, r103, r104, r111, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}

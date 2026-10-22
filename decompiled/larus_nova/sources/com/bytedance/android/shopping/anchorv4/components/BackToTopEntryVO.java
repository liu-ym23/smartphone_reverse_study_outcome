package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/BackToTopEntryVO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/components/BackToTopEntryDisplay;", "display", "Lcom/bytedance/android/shopping/anchorv4/components/BackToTopEntryDisplay;", "getDisplay", "()Lcom/bytedance/android/shopping/anchorv4/components/BackToTopEntryDisplay;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/components/BackToTopEntryDisplay;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackToTopEntryVO implements Serializable {
    public static final a Companion = null;

    @SerializedName("display")
    private final BackToTopEntryDisplay display;

    public static final class a {
        public a() {
        }

        public static BackToTopEntryVO a(ComponentDTO r100) {
            Object r101 = null;
            if (r100 != null) goto L19;
            return null;
        L19:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            VO r103 = r100.getVo();     // Catch: Throwable -> L11
            if (r103 == null) goto L8;
            JsonObject r104 = r103.getDisplay();     // Catch: Throwable -> L11
        L9:
            Object r105 = Result.m9449constructorimpl(new BackToTopEntryVO((BackToTopEntryDisplay) u0.a(r104, BackToTopEntryDisplay.class)));     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r105) == true) goto L18;
            r101 = r105;
        L18:
            return (BackToTopEntryVO) r101;
        L8:
            r104 = null;
        L11:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackToTopEntryVO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final BackToTopEntryDisplay getDisplay() {
        return this.display;
    }

    public BackToTopEntryVO(BackToTopEntryDisplay r100) {
        this.display = r100;
    }

    public /* synthetic */ BackToTopEntryVO(BackToTopEntryDisplay r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

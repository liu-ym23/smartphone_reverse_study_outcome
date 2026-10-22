package com.bytedance.android.livesdk.livecommerce.playback.applog;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/applog/ExplainPlayBackPDPEntryLogExtra;", "Ljava/io/Serializable;", "", "isFloat", "Ljava/lang/String;", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "entranceForm", "getEntranceForm", "setEntranceForm", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlayBackPDPEntryLogExtra implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String entranceForm;
    private String isFloat;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExplainPlayBackPDPEntryLogExtra() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final String getEntranceForm() {
        return this.entranceForm;
    }

    public final String isFloat() {
        return this.isFloat;
    }

    public final void setEntranceForm(String r100) {
        this.entranceForm = r100;
    }

    public final void setFloat(String r100) {
        this.isFloat = r100;
    }

    public ExplainPlayBackPDPEntryLogExtra(String r100, String r101) {
        this.isFloat = r100;
        this.entranceForm = r101;
    }

    public /* synthetic */ ExplainPlayBackPDPEntryLogExtra(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

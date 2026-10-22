package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.impl.util.e;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.vivo.push.PushClientConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/btm/impl/page/unknown/UnionData;", "Ljava/io/Serializable;", "", "pageId", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "", "unionStep", "I", "getUnionStep", "()I", "setUnionStep", "(I)V", "unionPre", "getUnionPre", "setUnionPre", "pageBtm", "getPageBtm", "setPageBtm", PushClientConstants.TAG_CLASS_NAME, "getClassName", "setClassName", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public class UnionData implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 20221017;
    private String className;
    private String pageBtm;
    private String pageId;
    private String unionPre;
    private int unionStep;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UnionData() {
        this.pageId = e.c();
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getPageBtm() {
        return this.pageBtm;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getUnionPre() {
        return this.unionPre;
    }

    public final int getUnionStep() {
        return this.unionStep;
    }

    public final void setClassName(String r100) {
        this.className = r100;
    }

    public final void setPageBtm(String r100) {
        this.pageBtm = r100;
    }

    public final void setPageId(String r100) {
        this.pageId = r100;
    }

    public final void setUnionPre(String r100) {
        this.unionPre = r100;
    }

    public final void setUnionStep(int r100) {
        this.unionStep = r100;
    }
}

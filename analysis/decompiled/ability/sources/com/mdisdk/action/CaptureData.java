package com.mdisdk.action;

import android.graphics.Bitmap;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/mdisdk/action/CaptureData;", "", "tag", "", "bitmap", "Landroid/graphics/Bitmap;", "isSecureWindow", "", "resultCode", "", "resultMessage", AppAgent.CONSTRUCT, "(Ljava/lang/String;Landroid/graphics/Bitmap;ZILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "getResultCode", "()I", "getResultMessage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CaptureData {
    private final Bitmap bitmap;
    private final boolean isSecureWindow;
    private final int resultCode;
    private final String resultMessage;
    private final String tag;

    public CaptureData(String tag, Bitmap bitmap, boolean z10, int i, String str) {
        k.f(tag, "tag");
        k.f(bitmap, "bitmap");
        this.tag = tag;
        this.bitmap = bitmap;
        this.isSecureWindow = z10;
        this.resultCode = i;
        this.resultMessage = str;
    }

    public static /* synthetic */ CaptureData copy$default(CaptureData captureData, String str, Bitmap bitmap, boolean z10, int i, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = captureData.tag;
        }
        if ((i6 & 2) != 0) {
            bitmap = captureData.bitmap;
        }
        if ((i6 & 4) != 0) {
            z10 = captureData.isSecureWindow;
        }
        if ((i6 & 8) != 0) {
            i = captureData.resultCode;
        }
        if ((i6 & 16) != 0) {
            str2 = captureData.resultMessage;
        }
        String str3 = str2;
        boolean z11 = z10;
        return captureData.copy(str, bitmap, z11, i, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component2, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSecureWindow() {
        return this.isSecureWindow;
    }

    /* renamed from: component4, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getResultMessage() {
        return this.resultMessage;
    }

    public final CaptureData copy(String tag, Bitmap bitmap, boolean isSecureWindow, int resultCode, String resultMessage) {
        k.f(tag, "tag");
        k.f(bitmap, "bitmap");
        return new CaptureData(tag, bitmap, isSecureWindow, resultCode, resultMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureData)) {
            return false;
        }
        CaptureData captureData = (CaptureData) other;
        return k.b(this.tag, captureData.tag) && k.b(this.bitmap, captureData.bitmap) && this.isSecureWindow == captureData.isSecureWindow && this.resultCode == captureData.resultCode && k.b(this.resultMessage, captureData.resultMessage);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getResultMessage() {
        return this.resultMessage;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int iA = a.a(this.resultCode, androidx.appfunctions.metadata.a.d((this.bitmap.hashCode() + (this.tag.hashCode() * 31)) * 31, 31, this.isSecureWindow), 31);
        String str = this.resultMessage;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public final boolean isSecureWindow() {
        return this.isSecureWindow;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CaptureData(tag=");
        sb.append(this.tag);
        sb.append(", bitmap=");
        sb.append(this.bitmap);
        sb.append(", isSecureWindow=");
        sb.append(this.isSecureWindow);
        sb.append(", resultCode=");
        sb.append(this.resultCode);
        sb.append(", resultMessage=");
        return B7.a.g(')', this.resultMessage, sb);
    }

    public /* synthetic */ CaptureData(String str, Bitmap bitmap, boolean z10, int i, String str2, int i6, e eVar) {
        this(str, bitmap, (i6 & 4) != 0 ? false : z10, (i6 & 8) != 0 ? 0 : i, (i6 & 16) != 0 ? null : str2);
    }
}

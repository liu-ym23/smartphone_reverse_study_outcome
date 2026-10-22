package io.ktor.utils.io.core;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f*\f\b\u0007\u0010\r\"\u00020\u00042\u00020\u0004¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", ContentDisposition.Parameters.Size, "Lkotlin/Function1;", "", "block", "withMemory", "(ILp9/l;)Ljava/lang/Object;", "index", UxipConstants.f30680s, "LY8/t;", "storeIntAt", "([BII)V", "Memory", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MemoryKt {
    public static /* synthetic */ void Memory$annotations() {
    }

    public static final void storeIntAt(byte[] bArr, int i10, int i11) {
        p.i(bArr, "<this>");
        bArr[i10] = (byte) (i11 >> 24);
        bArr[i10 + 1] = (byte) (i11 >> 16);
        bArr[i10 + 2] = (byte) (i11 >> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    public static final <T> T withMemory(int i10, InterfaceC5074l<? super byte[], ? extends T> block) {
        p.i(block, "block");
        return block.invoke(new byte[i10]);
    }
}

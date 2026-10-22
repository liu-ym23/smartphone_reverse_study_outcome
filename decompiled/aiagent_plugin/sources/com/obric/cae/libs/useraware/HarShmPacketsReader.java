package com.obric.cae.libs.useraware;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.OsConstants;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class HarShmPacketsReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f31784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedMemory f31785b;

    public HarShmPacketsReader() {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static int getSingleBufferSize() {
        return 65536;
    }

    public void closeShm() {
        ByteBuffer r0 = this.f31784a;
        if (r0 == null) goto L5;
        SharedMemory.unmap(r0);
        this.f31784a = null;
    L5:
        SharedMemory r1 = this.f31785b;
        if (r1 == null) goto L9;
        r1.close();
        this.f31785b = null;
        return;
    }

    public ByteBuffer getHarShmMappedBuffer() {
        return this.f31784a;
    }

    public boolean openShm(ParcelFileDescriptor r4) {
        this.f31785b = SharedMemory.fromFileDescriptor(r4);     // Catch: Throwable -> L6
        r4.close();     // Catch: Throwable -> L6
        SharedMemory r5 = this.f31785b;     // Catch: Throwable -> L6
        this.f31784a = r5.map(OsConstants.PROT_READ, 0, r5.getSize());     // Catch: Throwable -> L6
        return true;
    L6:
        e = move-exception;
        this.f31784a = null;
        e.printStackTrace();
        return false;
    }

    public List<UnifiedDataPacket> processDataBatch(ByteBuffer r9, int r10, int r11) {
        int r12 = r10 * 65536;
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L3:
        if (r3 >= r11) goto L24;
        r9.position(r12 + r3);
        if (r9.remaining() < 4) goto L6;
        int r4 = r9.getInt();
        if (r4 <= 0) goto L23;
        if (r4 > 65536) goto L23;
        if (r9.remaining() < r4) goto L13;
        byte[] r5 = new byte[r4];
        r9.get(r5);
        Parcelable.Creator<UnifiedDataPacket> r6 = UnifiedDataPacket.CREATOR;
        Parcel r7 = Parcel.obtain();
        r7.unmarshall(r5, 0, r4);     // Catch: Throwable -> L20
        r7.setDataPosition(0);     // Catch: Throwable -> L20
        Parcelable r8 = (Parcelable) ZeusTransformUtils.preCheckCast(r6.createFromParcel(r7), Parcelable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        r7.recycle();
        UnifiedDataPacket r13 = (UnifiedDataPacket) ZeusTransformUtils.preCheckCast(r8, UnifiedDataPacket.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L19;
        r1.add(r13);
    L19:
        r3 = r3 + (r4 + 4);
    L20:
        th = move-exception;
        r7.recycle();
        throw th;
    L13:
        INVOKESTATIC_com_obric_cae_libs_useraware_HarShmPacketsReader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("HarShmPacketsReader", "Buffer underflow when reading packet data. Declared length: " + r4);
    L23:
        INVOKESTATIC_com_obric_cae_libs_useraware_HarShmPacketsReader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("HarShmPacketsReader", "Invalid packet length detected: " + r4);
        goto L24
    L6:
        INVOKESTATIC_com_obric_cae_libs_useraware_HarShmPacketsReader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("HarShmPacketsReader", "Buffer underflow when reading packet length.");
    L24:
        return r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_useraware_HarShmPacketsReader_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}

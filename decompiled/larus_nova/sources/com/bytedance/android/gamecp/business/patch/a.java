package com.bytedance.android.gamecp.business.patch;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.bouncycastle.asn1.cmc.BodyPartID;
import wu.q1;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.patch.a$a, reason: collision with other inner class name */
    public static final class C0904a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f56215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f56216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f56217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f56218d;

        public C0904a() {
        }

        public final String toString() {
            return "Md5Result{adler32=" + this.f56215a + ", fileLength=" + this.f56216b + '}';
        }
    }

    static {
    }

    public static C0904a a(String r210) throws IOException {
        if (r210 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L169;
        if (Intrinsics.areEqual(q1.f561373a.getValue().q(), Boolean.TRUE) == false) goto L71;
        int r101 = b.f56219a;
        Intrinsics.checkNotNullParameter(r210, "apkPath");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r210);
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r102);     // Catch: IOException -> L62
        long r104 = RangesKt.coerceAtLeast(0, r102.length() - ((long) 65558));     // Catch: Throwable -> L53
        byte[] r105 = new byte[65558];     // Catch: Throwable -> L53
        r103.skip(r104);     // Catch: Throwable -> L53
        int r110 = r103.read(r105) - 22;     // Catch: Throwable -> L53
    L15:
        if (r110 < 0) goto L26;
        if (r105[r110] != 80) goto L25;
        if (r105[r110 + 1] != 75) goto L25;
        if (r105[r110 + 2] != 5) goto L25;
        if (r105[r110 + 3] != 6) goto L25;
        long r106 = r104 + ((long) r110);     // Catch: Throwable -> L53
    L28:
        if (r106 != (-1)) goto L34;
        long[] r107 = {-1, -1};     // Catch: Throwable -> L53
        CloseableKt.closeFinally(r103, null);     // Catch: IOException -> L62
        char r108 = 0;
    L66:
        long r109 = r107[r108];
        yr.c.a("game_apk_md5_ApkMd5NewCalculator", "signOffset is " + r109);
        if (r109 == (-1)) goto L69;
        yr.c.a("game_apk_md5_ApkMd5NewCalculator", "signOffset is " + r109 + ", 计算签名区前面的adler32校验和");
        C0904a r111 = b.a(r210, r109);
    L70:
        yr.c.a("game_apk_md5_ApkMd5Calculator", "calculateOldAdler32() new calculate, " + r111);
    L167:
        return r111;
    L69:
        yr.c.a("game_apk_md5_ApkMd5NewCalculator", "signOffset is -1, 计算整个文件的adler32校验和");
        r111 = b.a(r210, -1);
        goto L70
    L34:
        byte[] r112 = new byte[4];     // Catch: Throwable -> L53
        long r113 = 16;
        r103.getChannel().position(r106 + r113);     // Catch: Throwable -> L53
        r103.read(r112);     // Catch: Throwable -> L53
        ByteBuffer r114 = ByteBuffer.wrap(r112);     // Catch: Throwable -> L53
        ByteOrder r115 = ByteOrder.LITTLE_ENDIAN;     // Catch: Throwable -> L53
        long r116 = ((long) r114.order(r115).getInt()) & BodyPartID.bodyIdMax;
        long r117 = r116 - r113;
        if (r117 >= 0) goto L195;
    L44:
        long r118 = -1;
    L175:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r103, null);     // Catch: IOException -> L49
    L65:
        r108 = 0;
        r107 = new long[]{r118, r116};
    L49:
        e = e;
    L64:
        e.printStackTrace();
    L51:
        Throwable th10 = th;
    L52:
        long r120 = r116;
        long r121 = r118;
        Throwable r122 = th10;
    L189:
        throw r122;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        CloseableKt.closeFinally(r103, r122);     // Catch: IOException -> L60
        throw th;     // Catch: IOException -> L60
    L60:
        e = e;
        r118 = r121;
        r116 = r120;
        goto L64
    L195:
        byte[] r123 = new byte[16];     // Catch: Throwable -> L42
        r103.getChannel().position(r117);     // Catch: Throwable -> L42
        r103.read(r123);     // Catch: Throwable -> L42
        if (Intrinsics.areEqual("APK Sig Block 42", new String(r123, Charsets.UTF_8)) == false) goto L44;
        yr.c.a("game_apk_md5_ApkMd5NewCalculator", "APK Sig Block 42 的位置: " + r117);     // Catch: Throwable -> L42
        byte[] r124 = new byte[8];     // Catch: Throwable -> L42
        r103.getChannel().position(r116 - ((long) 24));     // Catch: Throwable -> L42
        r103.read(r124);     // Catch: Throwable -> L42
        r118 = (r116 - ByteBuffer.wrap(r124).order(r115).getLong()) - ((long) 8);
    L42:
        th10 = th;
        r118 = -1;
    L25:
        r110 = r110 - 1;     // Catch: Throwable -> L53
        goto L15
    L26:
        r106 = -1;
    L53:
        th = move-exception;
        r122 = th;
        r121 = -1;
        r120 = -1;
    L62:
        e = e;
        r118 = -1;
        r116 = -1;
        goto L64
    L71:
        int r125 = c.f56220a;
        Intrinsics.checkNotNullParameter(r210, "apkPath");
        PolarisFileWrapper r126 = new PolarisFileWrapper(r210);
        PolarisFileInputStreamWrapper r127 = new PolarisFileInputStreamWrapper(r126);     // Catch: IOException -> L121
        long r128 = RangesKt.coerceAtLeast(0, r126.length() - ((long) 65558));     // Catch: Throwable -> L112
        byte[] r129 = new byte[65558];     // Catch: Throwable -> L112
        r127.skip(r128);     // Catch: Throwable -> L112
        int r130 = r127.read(r129) - 22;     // Catch: Throwable -> L112
    L74:
        if (r130 < 0) goto L85;
        if (r129[r130] != 80) goto L84;
        if (r129[r130 + 1] != 75) goto L84;
        if (r129[r130 + 2] != 5) goto L84;
        if (r129[r130 + 3] != 6) goto L84;
        long r131 = r128 + ((long) r130);     // Catch: Throwable -> L112
    L87:
        if (r131 != (-1)) goto L92;
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() 未找到 EoCD 记录");     // Catch: Throwable -> L112
        long[] r132 = {-1, -1};     // Catch: Throwable -> L112
        CloseableKt.closeFinally(r127, null);     // Catch: IOException -> L121
        char r133 = 0;
        char r134 = 1;
    L125:
        long r135 = r132[r133];
        long r136 = r132[r134];
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "calculateOldAdler32() signOffset is " + r135);
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "calculateOldAdler32()  CD 的偏移值是 " + r136);
        if (r135 == (-1)) goto L165;
        PolarisFileWrapper r137 = new PolarisFileWrapper(r210);
        PolarisFileInputStreamWrapper r138 = new PolarisFileInputStreamWrapper(r137);     // Catch: IOException -> L158
        byte[] r139 = new byte[(int) (r137.length() - r135)];     // Catch: Throwable -> L149
        r138.skip(r135);     // Catch: Throwable -> L149
        r138.read(r139);     // Catch: Throwable -> L149
        long r140 = ByteBuffer.wrap(r139, 0, 8).order(ByteOrder.LITTLE_ENDIAN).getLong();     // Catch: Throwable -> L149
        long r141 = 8;
    L132:
        if (r141 >= r140) goto L145;
        ByteBuffer r142 = ByteBuffer.wrap(r139, (int) r141, 8);     // Catch: Throwable -> L143
        ByteOrder r143 = ByteOrder.LITTLE_ENDIAN;     // Catch: Throwable -> L143
        long r144 = r142.order(r143).getLong();     // Catch: Throwable -> L143
        long r145 = r140;
        long r146 = 8;
        if (ByteBuffer.wrap(r139, (int) (r141 + r146), 4).order(r143).getInt() == 1896449818) goto L138;
        r141 = r141 + (r144 + r146);
        r140 = r145;
        goto L132
    L138:
        long[] r147 = {r141 + r135, r144};     // Catch: Throwable -> L149
        CloseableKt.closeFinally(r138, null);     // Catch: IOException -> L158
        long[] r148 = r147;
    L186:
    L161:
        if (r148 == null) goto L163;
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "calculateOldAdler32() ID为0x1A870971的签名分块偏移值: " + r148[0]);
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "calculateOldAdler32() ID为0x1A870971的签名分块大小: " + r148[1]);
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "calculateOldAdler32() ID为0x1A870971的签名分块结束位置: " + ((r148[0] + r148[1]) - 1));
    L164:
        r111 = c.a(r210, r135, r148, r136);
    L166:
        yr.c.a("game_apk_md5_ApkMd5Calculator", "calculateOldAdler32() old calculate, " + r111);
        goto L167
    L163:
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "calculateOldAdler32() 未找到ID为0x1A870971的签名分块。");
    L143:
        th = move-exception;
        Throwable r149 = th;
        r148 = null;
    L191:
        throw r149;     // Catch: Throwable -> L152
    L152:
        th = move-exception;
        CloseableKt.closeFinally(r138, r149);     // Catch: IOException -> L156
        throw th;     // Catch: IOException -> L156
    L156:
        e = e;
    L160:
        e.printStackTrace();
        goto L161
    L145:
        Unit r150 = Unit.INSTANCE;     // Catch: Throwable -> L149
        r148 = null;
        CloseableKt.closeFinally(r138, null);     // Catch: IOException -> L156
    L149:
        th = move-exception;
        r148 = null;
        r149 = th;
    L158:
        e = e;
        r148 = null;
        goto L160
    L165:
        r111 = c.a(r210, -1, null, -1);
        goto L166
    L92:
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() EoCD 记录偏移值: " + r131);     // Catch: Throwable -> L112
        byte[] r151 = new byte[4];     // Catch: Throwable -> L112
        long r152 = (long) 16;     // Catch: Throwable -> L112
        r127.getChannel().position(r131 + r152);     // Catch: Throwable -> L112
        r127.read(r151);     // Catch: Throwable -> L112
        ByteBuffer r153 = ByteBuffer.wrap(r151);     // Catch: Throwable -> L112
        ByteOrder r154 = ByteOrder.LITTLE_ENDIAN;     // Catch: Throwable -> L112
        long r155 = ((long) r153.order(r154).getInt()) & BodyPartID.bodyIdMax;
        long r156 = r155 - r152;
        if (r156 >= 0) goto L96;
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() cdOffset -16 小于0, 签名区域偏移值: -1, cdOffset = " + r155);     // Catch: Throwable -> L109
    L100:
        long r157 = -1;
    L197:
        Unit r158 = Unit.INSTANCE;     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r127, null);     // Catch: IOException -> L105
    L124:
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() 签名区域偏移值: " + r157);
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() CD 偏移值: " + r155);
        r133 = 0;
        r134 = 1;
        r132 = new long[]{r157, r155};
    L105:
        e = e;
        long r159 = r155;
        long r160 = r157;
    L123:
        e.printStackTrace();
        r157 = r160;
        r155 = r159;
    L107:
        th = th;
    L111:
        r159 = r155;
        r160 = r157;
        Throwable r161 = th;
    L181:
        throw r161;     // Catch: Throwable -> L115
    L115:
        th = move-exception;
        CloseableKt.closeFinally(r127, r161);     // Catch: IOException -> L119
        throw th;     // Catch: IOException -> L119
    L119:
        e = e;
        goto L123
    L96:
        byte[] r162 = new byte[16];     // Catch: Throwable -> L109
        r127.getChannel().position(r156);     // Catch: Throwable -> L109
        r127.read(r162);     // Catch: Throwable -> L109
        String r163 = new String(r162, Charsets.UTF_8);     // Catch: Throwable -> L109
        yr.c.a("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() magic = " + r163 + ", SIGNATURE_BLOCK_MAGIC = APK Sig Block 42");     // Catch: Throwable -> L109
        if (Intrinsics.areEqual("APK Sig Block 42", r163) == false) goto L100;
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "getSignAreaOffsetAndCDOffset() APK Sig Block 42 的位置: " + r156);     // Catch: Throwable -> L109
        byte[] r164 = new byte[8];     // Catch: Throwable -> L109
        r127.getChannel().position(r155 - ((long) 24));     // Catch: Throwable -> L109
        r127.read(r164);     // Catch: Throwable -> L109
        r157 = (r155 - ByteBuffer.wrap(r164).order(r154).getLong()) - ((long) 8);     // Catch: Throwable -> L109
    L109:
        th = th;
        r157 = -1;
    L84:
        r130 = r130 - 1;     // Catch: Throwable -> L112
        goto L74
    L85:
        r131 = -1;
    L112:
        th = move-exception;
        r161 = th;
        r160 = -1;
        r159 = -1;
    L121:
        e = e;
        r160 = -1;
        r159 = -1;
        goto L123
    L169:
        throw new IOException("apkPath is empty");
    L5:
        if (r210.length() == 0) goto L8;
        r100 = false;
        goto L9
    }
}

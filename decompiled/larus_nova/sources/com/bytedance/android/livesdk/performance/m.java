package com.bytedance.android.livesdk.performance;

import android.app.Application;
import android.content.SharedPreferences;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.p00;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.fresco.heif.HeifDecoder;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.tailor.Tailor;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f154681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bo2.b f154682b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f154683c = null;

    public static final class a implements ff7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f154684a;

        @Override // ff7.e
        public final void onSuccess() {
            boolean r100 = m.f154681a;
            m.d(true, this.f154684a);
        }

        public a(PolarisFileWrapper r100) {
            this.f154684a = r100;
        }

        @Override // ff7.e
        public final void onFail(String r100) {
            boolean r101 = m.f154681a;
            m.d(false, this.f154684a);
        }
    }

    static {
        f154682b = new bo2.b(new bo2.e(), new bo2.d());
        f154683c = new AtomicBoolean(true);
    }

    @JvmStatic
    public static final boolean a() {
        o r100 = p00.f120946a.getValue();
        boolean r101 = r100.anchorEnable;
        if (r101 == false) goto L8;
        if (r100.audienceEnable == false) goto L8;
        return true;
    L8:
        if (r101 == false) goto L10;
    L12:
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 != null) goto L15;
        return false;
    L15:
        boolean r103 = r102.isAnchor().getValue().booleanValue();
        if (r103 == true) goto L18;
    L19:
        if (r103 == false) goto L21;
    L23:
        return false;
    L21:
        if (r100.audienceEnable == false) goto L23;
        return true;
    L18:
        if (r100.anchorEnable == false) goto L19;
        return true;
    L10:
        if (r100.audienceEnable == true) goto L12;
        return false;
    }

    public static void b(HashMap r100) {
        r100.put("dump_type", "threshold");
        Room r101 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r101 == null) goto L5;
        Long r102 = Long.valueOf(r101.getRoomId());
    L6:
        r100.put("room_id", String.valueOf(r102));
        com.bytedance.android.livesdk.log.u.l().sendLog("ttlive_start_live_dump_info", r100, new Object[0]);
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JvmStatic
    public static final void c(Map<String, Long> r210) {
        if (r210 != null) goto L5;
        return;
    L5:
        Application r100 = jc1.a.b();
        if (r100 != null) goto L9;
        return;
    L9:
        if (f154681a == false) goto L11;
        return;
    L11:
        Long r101 = r210.get("mem_java_used");
        if (r101 == null) goto L179;
        long r102 = r101.longValue();
        long r103 = Runtime.getRuntime().maxMemory();
        if (r102 > 0) goto L16;
        return;
    L16:
        if (r103 <= 0) goto L181;
        o r104 = p00.f120946a.getValue();
        int r110 = 0;
        PolarisFileWrapper r111 = null;
        File r112 = null;
        r112 = null;
        r111 = null;
        if (((r102 * ((long) 100)) / r103) < r104.javaHeapUsedPercent) goto L21;
        long r105 = System.currentTimeMillis();
        if (n.f154689a != null) goto L56;
        n.f154689a = r100.getSharedPreferences("live_hprofdumpper_sp", 0);
    L56:
        SharedPreferences r106 = n.f154689a;
        if (r106 != null) goto L59;
        long r113 = System.currentTimeMillis();
    L61:
        if ((r105 - r113) >= r104.a()) goto L64;
        return;
    L64:
        if (n.f154689a != null) goto L66;
        n.f154689a = r100.getSharedPreferences("live_hprofdumpper_sp", 0);
    L66:
        SharedPreferences r107 = n.f154689a;
        if (r107 == null) goto L73;
        SharedPreferences.Editor r108 = r107.edit();
        if (r108 == null) goto L73;
        SharedPreferences.Editor r109 = r108.putLong("last_dump_time", r105);
        if (r109 == null) goto L73;
        r109.apply();
    L73:
        bo2.b r114 = f154682b;
        if (Intrinsics.areEqual(r104.uploadStrategy, "ttlive") == false) goto L76;
        bo2.c r115 = new bo2.h();
    L77:
        r114.getClass();
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r114.f19791a = r115;
        IHostContext r116 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r116 != null) goto L81;
        return;
    L81:
        if (r116.getServerDeviceId() != null) goto L83;
        return;
    L83:
        HashMap r117 = new HashMap();
        File r118 = r100.getExternalFilesDir("live.hprofdumpper");
        if (r118 != null) goto L87;
    L90:
        PolarisFileWrapper r119 = null;
    L93:
        if (r119 == null) goto L95;
        r117.put("dump_status", "start");
        b(r117);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r119, "hprofFile");
        Intrinsics.checkNotNullParameter("threshold", "scene");
        File r120 = r114.f19792b.a(r100, r119);
    L96:
        if (r120 != null) goto L98;
    L155:
        r117.put("dump_status", "dump_fail");
        b(r117);
        return;
    L98:
        if (r120.exists() == false) goto L155;
        if (r120.length() <= 0) goto L155;
        r117.put("dump_status", "dump_success");
        b(r117);
        if (r104.crop == true) goto L105;
    L119:
        PolarisFileWrapper r121 = new PolarisFileWrapper(r120.getParentFile(), "dump.zip");
        ZipOutputStream r122 = new ZipOutputStream(new PolarisFileOutputStreamWrapper(r121));     // Catch: Throwable -> L131
        r122.putNextEntry(new ZipEntry(r120.getName()));     // Catch: Throwable -> L139
        PolarisFileInputStreamWrapper r123 = new PolarisFileInputStreamWrapper(r120);     // Catch: Throwable -> L139
        byte[] r124 = new byte[4096];     // Catch: Throwable -> L132
    L124:
        int r125 = r123.read(r124);     // Catch: Throwable -> L132
        if (r125 < 0) goto L127;
        r122.write(r124, 0, r125);     // Catch: Throwable -> L132
        goto L124
    L127:
        Unit r126 = Unit.INSTANCE;     // Catch: Throwable -> L132
        CloseableKt.closeFinally(r123, null);     // Catch: Throwable -> L139
        r122.closeEntry();     // Catch: Throwable -> L139
        CloseableKt.closeFinally(r122, null);     // Catch: Throwable -> L131
        r111 = r121;
    L149:
        r120.delete();
        if (r111 != null) goto L153;
        r117.put("dump_status", "zip_fail");
        b(r117);
        return;
    L153:
        f154681a = true;
        bo2.b r127 = f154682b;
        a r128 = new a(r111);
        r127.getClass();
        Intrinsics.checkNotNullParameter(r111, "file");
        Intrinsics.checkNotNullParameter(r128, "callback");
        r127.f19791a.a(r111, r128);
        return;
    L132:
        th = move-exception;
        throw th;     // Catch: Throwable -> L135
    L135:
        th = move-exception;
        CloseableKt.closeFinally(r123, th);     // Catch: Throwable -> L139
        throw th;     // Catch: Throwable -> L139
    L139:
        th = move-exception;
        throw th;     // Catch: Throwable -> L142
    L142:
        th = move-exception;
        CloseableKt.closeFinally(r122, th);     // Catch: Throwable -> L131
        throw th;     // Catch: Throwable -> L131
    L147:
        if (r121.exists() == false) goto L149;
        r121.delete();
        goto L149
    L105:
        if (r120.length() < HeifDecoder.MAX_BITMAP_SIZE) goto L118;
        PolarisFileWrapper r129 = new PolarisFileWrapper(r120.getParentFile(), "mini.hprof");
        r120.toString();     // Catch: Throwable -> L109
        r129.toString();     // Catch: Throwable -> L109
        Tailor.tailorHprof(r120.getAbsolutePath(), r129.getAbsolutePath());     // Catch: Throwable -> L109
    L113:
        r120.delete();
        if (r129 != null) goto L117;
        HashMap r130 = new HashMap();
        r130.put("dump_status", "crop_fail");
        b(r130);
        return;
    L117:
        r120 = r129;
    L110:
        if (r129.exists() == false) goto L112;
        r129.delete();
    L112:
        r129 = null;
        goto L113
    L118:
        r120.length();
        goto L119
    L95:
        r120 = null;
        goto L96
    L87:
        if (r118.exists() == false) goto L89;
    L91:
        r119 = new PolarisFileWrapper(r118, "dump.hprof");
        goto L93
    L89:
        if (r118.mkdirs() == true) goto L91;
    L76:
        r115 = new bo2.e();
        goto L77
    L59:
        r113 = r106.getLong("last_dump_time", 0);
        goto L61
    L21:
        if (f154683c.getAndSet(false) == false) goto L172;
        File r131 = r100.getExternalFilesDir("live.hprofdumpper");
        if (r131 != null) goto L25;
        return;
    L25:
        if (r131.exists() == false) goto L176;
        File[] r132 = r131.listFiles();
        if (r132 == null) goto L38;
        int r133 = r132.length;
    L30:
        if (r110 >= r133) goto L38;
        File r134 = r132[r110];
        if (r134 == null) goto L37;
        if (Intrinsics.areEqual(r134.getName(), "dump.zip") == false) goto L36;
        r112 = r134;
        goto L37
    L36:
        r134.delete();
    L37:
        r110 = r110 + 1;
    L38:
        if (r112 != null) goto L41;
        return;
    L41:
        if (r112.exists() == false) goto L178;
        PolarisFileWrapper r135 = new PolarisFileWrapper(r131, "dump.zip.bak");
        if (r135.exists() == false) goto L47;
        r135.delete();
    L47:
        if (r112.renameTo(r135) == false) goto L49;
        r135.getName();
        f154681a = true;
        bo2.b r136 = f154682b;
        l r137 = new l(r135);
        r136.getClass();
        Intrinsics.checkNotNullParameter(r135, "file");
        Intrinsics.checkNotNullParameter(r137, "callback");
        r136.f19791a.a(r135, r137);
        return;
    L49:
        if (r112.exists() == false) goto L174;
        r112.delete();
        return;
    L174:
        return;
    L178:
        return;
    L176:
        return;
    L172:
        return;
    L181:
        return;
    }

    public static void d(boolean r100, File r101) {
        HashMap r102 = new HashMap();
        if (r100 == false) goto L5;
        String r103 = "upload_success";
    L6:
        r102.put("dump_status", r103);
        b(r102);
        if (r101.exists() == false) goto L9;
        r101.delete();
    L9:
        f154681a = false;
        return;
    L5:
        r103 = EventConstant.Value.UPLOAD_FAIL;
        goto L6
    }
}

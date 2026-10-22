package p5;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.room.a0;
import androidx.room.x;
import androidx.work.impl.WorkDatabase;
import b8.r0;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.integration.android.AndroidKeysetManager;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import com.google.crypto.tink.streamingaead.StreamingAeadConfig;
import ie.i0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import s1.a1;
import stepos.support.v7.app.h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements r0, qe.f, a1 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9721c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9722f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9723g;

    public e(Context context) throws PackageManager.NameNotFoundException {
        this.f9721c = 1;
        ArrayList arrayListN = id.k.n(context);
        a9.o oVar = new a9.o();
        oVar.f294a = arrayListN;
        VarHandle.storeStoreFence();
        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.getClass();
        File databasePath = context.getDatabasePath("file_trash_media.db");
        databasePath.getClass();
        l lVar = new l();
        lVar.f9738c = contentResolver;
        lVar.f9739f = databasePath;
        VarHandle.storeStoreFence();
        context.getClass();
        this.f9722f = oVar;
        this.f9723g = lVar;
    }

    public static a9.h A(Serializable serializable) {
        Throwable thB = jb.i.b(serializable);
        String message = thB != null ? thB.getMessage() : null;
        a9.c cVar = a9.c.f246f;
        a9.c cVar2 = yb.k.a(message, "INVALID_REQUEST") ? cVar : a9.c.f247g;
        return f7.f.g(cVar2, cVar2 == cVar ? "Path is required" : "Path is outside external storage");
    }

    public static a9.j a(List list, ArrayList arrayList, String str, String str2) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                if (i != 0 || i10 <= 0) {
                    return f7.f.q(str2, (String) kb.l.w0(list), str, i, i10, arrayList2, null, list, 64);
                }
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj = arrayList.get(i12);
                    i12++;
                    if (obj instanceof a9.h) {
                        arrayList3.add(obj);
                    }
                }
                ArrayList arrayList4 = new ArrayList(kb.m.m0(arrayList3, 10));
                int size3 = arrayList3.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj2 = arrayList3.get(i13);
                    i13++;
                    arrayList4.add(((a9.h) obj2).f264a);
                }
                List listL0 = kb.l.L0(kb.l.N0(arrayList4));
                a9.c cVar = (a9.c) (listL0.size() == 1 ? listL0.get(0) : null);
                if (cVar == null) {
                    cVar = str.equals("restored_count") ? a9.c.f252m : a9.c.f249j;
                }
                String strB0 = kb.l.B0(kb.l.J0(arrayList2, 10), "; ", null, null, null, 62);
                String str3 = (String) kb.l.w0(list);
                Integer numValueOf = Integer.valueOf(i10);
                long jCurrentTimeMillis = System.currentTimeMillis();
                a9.h hVar = new a9.h();
                hVar.f264a = cVar;
                hVar.f265b = strB0;
                hVar.f266c = str2;
                hVar.f267d = str3;
                hVar.f268e = str;
                hVar.f269f = 0;
                hVar.f270g = numValueOf;
                hVar.f271h = arrayList2;
                hVar.i = list;
                hVar.f272j = jCurrentTimeMillis;
                VarHandle.storeStoreFence();
                return hVar;
            }
            Object obj3 = arrayList.get(i11);
            i11++;
            int i14 = i3 + 1;
            if (i3 < 0) {
                ac.a.a0();
                throw null;
            }
            a9.j jVar = (a9.j) obj3;
            if (jVar instanceof a9.i) {
                a9.i iVar = (a9.i) jVar;
                i += iVar.f276d;
                i10 += iVar.f277e;
                for (String str4 : iVar.f278f) {
                    arrayList2.add(list.get(i3) + ": " + str4);
                }
            } else {
                if (!(jVar instanceof a9.h)) {
                    g5.f.a();
                    return null;
                }
                i10++;
                arrayList2.add(list.get(i3) + ": " + ((a9.h) jVar).f265b);
            }
            i3 = i14;
        }
    }

    public static void d(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    d(file2);
                }
            }
        }
        File[] fileArrListFiles2 = file.listFiles();
        if (fileArrListFiles2 == null || fileArrListFiles2.length != 0) {
            return;
        }
        file.delete();
    }

    public static e6.e g(e6.i iVar, Throwable th) {
        if (th instanceof e6.l) {
            iVar.getClass();
            e6.c cVar = iVar.A;
            cVar.getClass();
            e6.c cVar2 = i6.c.f5803a;
            cVar.getClass();
        } else {
            iVar.A.getClass();
            e6.c cVar3 = i6.c.f5803a;
        }
        e6.e eVar = new e6.e();
        eVar.f3525a = null;
        eVar.f3526b = iVar;
        eVar.f3527c = th;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public static String h(List list) {
        Object next;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((a9.l) obj).f289g.equals("inode/directory")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((a9.l) obj2).f284b);
        }
        Set setO0 = kb.l.O0(arrayList2);
        gc.n nVarR0 = kb.l.r0(list);
        a9.e eVar = new a9.e(i);
        eVar.f257f = setO0;
        VarHandle.storeStoreFence();
        gc.h hVar = new gc.h(nVarR0, false, eVar);
        int i10 = 2;
        a9.d dVar = new a9.d(i10);
        gc.i iVar = new gc.i(i10);
        iVar.f4694b = hVar;
        iVar.f4695c = dVar;
        VarHandle.storeStoreFence();
        Iterator it = iVar.iterator();
        while (true) {
            gc.r rVar = (gc.r) it;
            if (!rVar.f4710f.hasNext()) {
                next = null;
                break;
            }
            next = rVar.next();
            if (new File((String) next).exists()) {
                break;
            }
        }
        return (String) next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object r(String str, List list) {
        kb.s sVar = null;
        String string = str != null ? hc.h.w0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k0.a.A((String) it.next(), arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            sVar = arrayList2;
        }
        if (sVar == null) {
            sVar = kb.s.f7404c;
        }
        if (string.length() > 0 && !sVar.isEmpty()) {
            return id.c.l(new IllegalArgumentException("BOTH_PATH_AND_PATHS"));
        }
        if (string.length() > 0) {
            return ac.a.E(string);
        }
        if (!sVar.isEmpty()) {
            return sVar;
        }
        a9.c cVar = a9.c.f246f;
        return id.c.l(new IllegalArgumentException("INVALID_REQUEST"));
    }

    public static a9.h z(Object obj) {
        Throwable thB = jb.i.b(obj);
        return f7.f.g(a9.c.f246f, yb.k.a(thB != null ? thB.getMessage() : null, "BOTH_PATH_AND_PATHS") ? "Provide either path or paths, not both" : "Path is required");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e6.m B(e6.m r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.graphics.Bitmap$Config r2 = r1.f3574b
            e6.b r3 = r1.f3586o
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.HARDWARE
            if (r2 != r4) goto L13
            java.lang.Object r4 = r0.f9723g
            i6.e r4 = (i6.e) r4
            r4.getClass()
        L13:
            e6.b r4 = r1.f3586o
            boolean r4 = r4.f3510c
            if (r4 == 0) goto L2f
            java.lang.Object r0 = r0.f9722f
            r4 = r0
            i6.f r4 = (i6.f) r4
            monitor-enter(r4)
            r4.a()     // Catch: java.lang.Throwable -> L2c
            boolean r0 = r4.i     // Catch: java.lang.Throwable -> L2c
            monitor-exit(r4)
            if (r0 != 0) goto L2f
            e6.b r3 = e6.b.f3509h
            r0 = 1
        L2a:
            r15 = r3
            goto L31
        L2c:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2c
            throw r0
        L2f:
            r0 = 0
            goto L2a
        L31:
            if (r0 == 0) goto L54
            android.content.Context r0 = r1.f3573a
            android.graphics.ColorSpace r3 = r1.f3575c
            f6.g r4 = r1.f3576d
            f6.f r5 = r1.f3577e
            boolean r6 = r1.f3578f
            boolean r7 = r1.f3579g
            boolean r8 = r1.f3580h
            java.lang.String r9 = r1.i
            ad.n r10 = r1.f3581j
            e6.r r11 = r1.f3582k
            e6.p r12 = r1.f3583l
            e6.b r13 = r1.f3584m
            e6.b r14 = r1.f3585n
            r1 = r0
            e6.m r0 = new e6.m
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.e.B(e6.m):e6.m");
    }

    @Override // s1.a1
    public boolean b(Object obj, Object obj2) {
        y.u uVar = (y.u) this.f9722f;
        return yb.k.a(uVar.b(obj), uVar.b(obj2));
    }

    @Override // s1.a1
    public void c(p.r0 r0Var) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f9723g;
        linkedHashMap.clear();
        Iterator it = r0Var.iterator();
        while (true) {
            gc.j jVar = (gc.j) it;
            if (!jVar.hasNext()) {
                return;
            }
            Object objB = ((y.u) this.f9722f).b(jVar.next());
            Integer num = (Integer) linkedHashMap.get(objB);
            int iIntValue = num != null ? num.intValue() : 0;
            if (iIntValue == 7) {
                jVar.remove();
            } else {
                linkedHashMap.put(objB, Integer.valueOf(iIntValue + 1));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x027d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a9.j e(java.io.File r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.e.e(java.io.File, java.lang.String):a9.j");
    }

    public u f(File file) {
        AndroidKeysetManager androidKeysetManagerBuild;
        Context context = (Context) this.f9722f;
        p8.a aVar = p8.a.f9923a;
        context.getClass();
        pc.t tVarA = aVar.a(context);
        Context applicationContext = context.getApplicationContext();
        String str = tVarA.f9985b;
        StreamingAeadConfig.register();
        AndroidKeysetManager.Builder builderWithMasterKeyUri = new AndroidKeysetManager.Builder().withKeyTemplate(KeyTemplates.get("AES256_GCM_HKDF_4KB")).withSharedPref(applicationContext, "__androidx_security_crypto_encrypted_file_keyset__", "__androidx_security_crypto_encrypted_file_pref__").withMasterKeyUri(AndroidKeystoreKmsClient.PREFIX + str);
        synchronized (w4.a.f15214a) {
            androidKeysetManagerBuild = builderWithMasterKeyUri.build();
        }
        StreamingAead streamingAead = (StreamingAead) androidKeysetManagerBuild.getKeysetHandle().getPrimitive(StreamingAead.class);
        u uVar = new u(11);
        uVar.f9807f = file;
        uVar.f9808g = streamingAead;
        VarHandle.storeStoreFence();
        return uVar;
    }

    public Long i(String str) {
        x xVarD = x.d(1, "SELECT long_value FROM Preference where `key`=?");
        xVarD.h(1, str);
        WorkDatabase workDatabase = (WorkDatabase) this.f9722f;
        workDatabase.b();
        Cursor cursorD = td.h.D(workDatabase, xVarD, false);
        try {
            Long lValueOf = null;
            if (cursorD.moveToFirst() && !cursorD.isNull(0)) {
                lValueOf = Long.valueOf(cursorD.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public void j(d dVar) {
        WorkDatabase workDatabase = (WorkDatabase) this.f9722f;
        workDatabase.b();
        workDatabase.c();
        try {
            ((b) this.f9723g).e(dVar);
            workDatabase.v();
        } finally {
            workDatabase.q();
        }
    }

    @Override // b8.r0
    public String k() {
        return (String) this.f9723g;
    }

    public void l() throws IOException {
        String str = (String) this.f9722f;
        if (((FileChannel) this.f9723g) != null) {
            return;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.f9723g = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = (FileChannel) this.f9723g;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.f9723g = null;
            throw new IllegalStateException(k0.a.C("Unable to lock file: '", str, "'."), th);
        }
    }

    public void m(k3.f fVar) {
        i0 i0Var = (i0) this.f9723g;
        a2.i iVar = (a2.i) this.f9722f;
        if (fVar.f7227b != 0) {
            a4.o oVar = new a4.o(2);
            VarHandle.storeStoreFence();
            i0Var.execute(oVar);
        } else {
            Typeface typeface = fVar.f7226a;
            com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(5);
            dVar.f2885f = iVar;
            dVar.f2886g = typeface;
            VarHandle.storeStoreFence();
            i0Var.execute(dVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e6.m n(e6.i r17, f6.g r18) {
        /*
            r16 = this;
            r0 = r17
            r4 = r18
            kb.s r1 = r0.f3553g
            android.graphics.Bitmap$Config r2 = r0.f3550d
            r1.getClass()
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.HARDWARE
            if (r2 != r1) goto L21
            if (r2 != r1) goto L18
            boolean r1 = r0.f3557l
            if (r1 != 0) goto L18
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            goto L21
        L18:
            r1 = r16
            java.lang.Object r1 = r1.f9723g
            i6.e r1 = (i6.e) r1
            r1.getClass()
        L21:
            p5.f r1 = r4.f3927a
            f6.b r3 = f6.b.f3917c
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L38
            p5.f r1 = r4.f3928b
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L34
            goto L38
        L34:
            f6.f r1 = r0.f3569x
        L36:
            r5 = r1
            goto L3b
        L38:
            f6.f r1 = f6.f.f3924f
            goto L36
        L3b:
            boolean r1 = r0.f3558m
            if (r1 == 0) goto L4b
            kb.s r1 = r0.f3553g
            r1.getClass()
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8
            if (r2 == r1) goto L4b
            r1 = 1
        L49:
            r7 = r1
            goto L4d
        L4b:
            r1 = 0
            goto L49
        L4d:
            e6.m r1 = new e6.m
            r3 = r1
            android.content.Context r1 = r0.f3547a
            boolean r6 = i6.c.a(r0)
            boolean r8 = r0.f3559n
            ad.n r10 = r0.i
            e6.r r11 = r0.f3555j
            e6.p r12 = r0.f3570y
            e6.b r13 = r0.f3560o
            e6.b r14 = r0.f3561p
            e6.b r15 = r0.f3562q
            r0 = r3
            r3 = 0
            r9 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.e.n(e6.i, f6.g):e6.m");
    }

    @Override // b8.r0
    public boolean o(JsonNode jsonNode) {
        JsonNode jsonNode2 = (JsonNode) this.f9722f;
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.POSITIVE_INFINITY) {
            return false;
        }
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.NEGATIVE_INFINITY) {
            return true;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
            return false;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
            return true;
        }
        int iCompareTo = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.f9723g));
        return iCompareTo > 0 || iCompareTo == 0;
    }

    @Override // qe.f
    public void onPrivacyPolicyClick(Context context) {
        com.stepos.policy.sdk.a aVar = ((h0) this.f9723g).f12325f;
        if (aVar != null) {
            aVar.onClick((TextView) this.f9722f);
        }
    }

    @Override // qe.f
    public void onUserAgreementClick(Context context) {
        View.OnClickListener onClickListener = ((h0) this.f9723g).f12326g;
        if (onClickListener != null) {
            onClickListener.onClick((TextView) this.f9722f);
        }
    }

    public byte[] p(File file) {
        Object objL;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        try {
            w4.b bVarE = f(file).e();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, bVarE.f15215c.available()));
                t.n.f(bVarE, byteArrayOutputStream);
                objL = byteArrayOutputStream.toByteArray();
                objL.getClass();
                bVarE.close();
            } finally {
            }
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        return (byte[]) (objL instanceof jb.h ? null : objL);
    }

    public void q(xb.l lVar) {
        ((z9.h) this.f9722f).a(lVar);
        View view = (View) ((WeakReference) this.f9723g).get();
        if (view == null) {
            return;
        }
        z9.i iVar = z9.i.f16559a;
        z9.h hVar = (z9.h) this.f9722f;
        synchronized (iVar) {
            try {
                int i = hVar.f16557b - 1;
                hVar.f16557b = i;
                if (i <= 0) {
                    if (view.isAttachedToWindow()) {
                        a0 a0Var = new a0(12);
                        a0Var.f1506f = hVar;
                        a0Var.f1507g = view;
                        VarHandle.storeStoreFence();
                        view.post(a0Var);
                    } else {
                        View view2 = (View) hVar.f16556a.get();
                        if (view2 != null) {
                            z9.b.a(view2, null);
                        }
                        z9.i.f16565g.remove(view);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public a9.j s(String str, List list, boolean z10) {
        Set set = p9.a.f9925a;
        Log.i("FileTrashManager", "restore path=" + p9.a.d(str) + " paths=" + (list != null ? list.size() : 0) + " recursive=" + z10);
        Object objR = r(str, list);
        if (objR instanceof jb.h) {
            return z(objR);
        }
        id.c.I(objR);
        List list2 = (List) objR;
        if (list2.size() == 1) {
            return u((String) kb.l.w0(list2), z10);
        }
        ArrayList arrayList = new ArrayList(kb.m.m0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(u((String) it.next(), z10));
        }
        return a(list2, arrayList, "restored_count", "batch_restore");
    }

    public a9.j t(String str, List list) {
        if (list.size() > 500) {
            return f7.f.g(a9.c.i, "Restore contains " + list.size() + " files");
        }
        String strH = h(list);
        if (strH != null) {
            return f7.f.g(a9.c.f251l, "Restore destination already exists: ".concat(strH));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            a9.l lVar = (a9.l) it.next();
            a9.o oVar = (a9.o) this.f9722f;
            boolean zEquals = lVar.f289g.equals("inode/directory");
            oVar.getClass();
            Object objI = a9.o.i(lVar, zEquals);
            if (objI instanceof jb.h) {
                String str2 = lVar.f284b;
                Throwable thB = jb.i.b(objI);
                arrayList.add(str2 + ": " + (thB != null ? thB.getMessage() : null));
            } else {
                i++;
            }
        }
        if (i != 0 || arrayList.isEmpty()) {
            return f7.f.q(list.size() == 1 ? "garbage_restore" : "recursive_restore", str, "restored_count", i, arrayList.size(), arrayList, null, null, 192);
        }
        return f7.f.g(a9.c.f252m, (String) kb.l.w0(arrayList));
    }

    public String toString() {
        switch (this.f9721c) {
            case 3:
                return String.format("VersionTagsTuple<%s, %s>", (vd.c) this.f9722f, (HashMap) this.f9723g);
            case 11:
                String string = "[ ";
                if (((u2.e) this.f9722f) != null) {
                    for (int i = 0; i < 9; i++) {
                        StringBuilder sbC = w2.c.c(string);
                        sbC.append(((u2.e) this.f9722f).f14020l[i]);
                        sbC.append(" ");
                        string = sbC.toString();
                    }
                }
                StringBuilder sbV = k0.a.v(string, "] ");
                sbV.append((u2.e) this.f9722f);
                return sbV.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a9.j u(java.lang.String r23, boolean r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.e.u(java.lang.String, boolean):a9.j");
    }

    public a9.j v(String str, List list, boolean z10) {
        Set set = p9.a.f9925a;
        Log.i("FileTrashManager", "safeDelete path=" + p9.a.d(str) + " paths=" + (list != null ? list.size() : 0) + " recursive=" + z10);
        Object objR = r(str, list);
        if (objR instanceof jb.h) {
            return z(objR);
        }
        id.c.I(objR);
        List list2 = (List) objR;
        if (list2.size() == 1) {
            return w((String) kb.l.w0(list2), z10);
        }
        ArrayList arrayList = new ArrayList(kb.m.m0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(w((String) it.next(), z10));
        }
        return a(list2, arrayList, "trashed_count", "batch_trash");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0266 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a9.j w(java.lang.String r25, boolean r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p5.e.w(java.lang.String, boolean):a9.j");
    }

    public void x(h5.j jVar, n6.a aVar) {
        jVar.getClass();
        i iVar = (i) this.f9723g;
        a4.l lVar = new a4.l(5);
        lVar.f185f = this;
        lVar.f186g = jVar;
        lVar.f187h = aVar;
        VarHandle.storeStoreFence();
        iVar.q(lVar);
    }

    public void y(h5.j jVar, int i) {
        jVar.getClass();
        ((i) this.f9723g).q(new q5.g((h5.d) this.f9722f, jVar, false, i));
    }

    public /* synthetic */ e(int i) {
        this.f9721c = i;
    }

    public e(vd.c cVar, HashMap map) {
        this.f9721c = 3;
        this.f9722f = cVar;
        this.f9723g = map;
    }

    public e(h5.d dVar, i iVar) {
        this.f9721c = 6;
        dVar.getClass();
        iVar.getClass();
        this.f9722f = dVar;
        this.f9723g = iVar;
    }
}

package s8;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.stepos.agentsafetycenter.R;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.io.File;
import java.lang.invoke.VarHandle;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final s0.c f11615a = new s0.c(2140190152, false, new e9.a(8));

    /* renamed from: b, reason: collision with root package name */
    public static final s0.c f11616b = new s0.c(-1953874743, false, new k8.d(17));

    /* renamed from: c, reason: collision with root package name */
    public static final s0.c f11617c = new s0.c(-1128792968, false, new e9.a(9));

    /* renamed from: d, reason: collision with root package name */
    public static final s0.c f11618d = new s0.c(-2050178578, false, new k8.d(18));

    public static final boolean A(Context context) {
        context.getClass();
        String[] strArr = {PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO, PolicySdkPermissionManifestUtils.READ_MEDIA_AUDIO};
        for (int i = 0; i < 3; i++) {
            if (d3.a.a(context, strArr[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    public static final boolean B(Context context, b3 b3Var) {
        context.getClass();
        int iOrdinal = b3Var.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        g5.f.a();
                        return false;
                    }
                    if (!Environment.isExternalStorageManager()) {
                        return A(context);
                    }
                } else if (d3.a.a(context, PolicySdkPermissionManifestUtils.READ_MEDIA_AUDIO) != 0) {
                    return false;
                }
            } else if (d3.a.a(context, PolicySdkPermissionManifestUtils.READ_MEDIA_VIDEO) != 0) {
                return false;
            }
        } else if (d3.a.a(context, PolicySdkPermissionManifestUtils.READ_MEDIA_IMAGES) != 0) {
            return false;
        }
        return true;
    }

    public static final w1 C(int i, int i3) {
        if (i < 0) {
            i = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i <= 0 && i3 <= 0) {
            return new w1(0, 0);
        }
        if (i <= 0) {
            if (i3 > 2) {
                i3 = 2;
            }
            return new w1(0, i3);
        }
        if (i3 <= 0) {
            if (i > 2) {
                i = 2;
            }
            return new w1(i, 0);
        }
        if (i > 2) {
            i = 2;
        }
        return new w1(i, 0);
    }

    public static final int D(String str) {
        Integer numV;
        str.getClass();
        String str2 = (String) kb.l.y0(0, hc.h.p0(hc.h.w0(str).toString(), new char[]{':'}));
        if (str2 == null || (numV = hc.o.V(str2)) == null) {
            return 0;
        }
        return p5.f.q(numV.intValue(), 0, 23);
    }

    public static boolean E(p3 p3Var) {
        u8.p pVar = p3Var.f11899z;
        if (pVar == u8.p.f14244f || pVar == u8.p.f14245g) {
            return false;
        }
        int iOrdinal = t0.a.k(p3Var.f11898y).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                g5.f.a();
                return false;
            }
        }
        return true;
    }

    public static String F(p3 p3Var) {
        return hc.h.w0(p3Var.f11886m).toString() + "#" + kb.l.B0(x0.c(p3Var), "|", null, null, null, 62) + "#" + p3Var.f11895v;
    }

    public static final String G(String str) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        return string.length() < 7 ? str : k0.a.o(hc.h.t0(3, string), "****", hc.h.u0(4, string));
    }

    public static final String H(String str) {
        str.getClass();
        String string = hc.h.w0(str).toString();
        if (string.length() == 0) {
            return null;
        }
        return hc.o.U(string, "/sdcard/", false) ? "/storage/emulated/0/".concat(hc.h.l0(string, "/sdcard/")) : string;
    }

    public static final Uri I(Cursor cursor, Uri uri, String str) throws IllegalArgumentException {
        if (hc.h.g0(str) || !cursor.moveToFirst()) {
            return null;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_display_name");
        do {
            String string = cursor.getString(columnIndexOrThrow2);
            if (string == null) {
                string = "";
            }
            if (string.equalsIgnoreCase(str)) {
                Uri uriWithAppendedId = ContentUris.withAppendedId(uri, cursor.getLong(columnIndexOrThrow));
                uriWithAppendedId.getClass();
                Log.i("RevokeMedia", "trash pick exact-name uri=" + uriWithAppendedId + " name=" + string);
                return uriWithAppendedId;
            }
        } while (cursor.moveToNext());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x019f A[LOOP:0: B:6:0x002b->B:97:0x019f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0167 A[EDGE_INSN: B:98:0x0167->B:92:0x0167 BREAK  A[LOOP:0: B:6:0x002b->B:97:0x019f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.net.Uri J(android.database.Cursor r24, android.net.Uri r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, boolean r29) throws java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.g1.J(android.database.Cursor, android.net.Uri, java.lang.String, java.lang.String, java.lang.String, boolean):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.net.Uri K(android.content.Context r21, android.net.Uri r22, java.lang.String r23, s8.b3 r24, java.lang.String r25, java.lang.String r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.g1.K(android.content.Context, android.net.Uri, java.lang.String, s8.b3, java.lang.String, java.lang.String, boolean):android.net.Uri");
    }

    public static t L(Context context, t tVar) {
        String str;
        context.getClass();
        List list = tVar.f11967e;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int size = 0;
        int i = 0;
        while (true) {
            j3 j3VarA = null;
            if (!it.hasNext()) {
                break;
            }
            j3 j3Var = (j3) it.next();
            List<p3> list2 = j3Var.f11702e;
            ArrayList arrayList2 = new ArrayList();
            for (p3 p3VarA : list2) {
                if ((p3VarA.f11899z == u8.p.f14243c && x0.t(p3VarA)) || (!p3VarA.D && x0.t(p3VarA))) {
                    if (z(context, p3VarA)) {
                        p3VarA = p3.a(p3VarA, null, null, null, null, null, null, null, 0L, null, null, null, null, 1065353215);
                    } else {
                        i++;
                        Log.i("UndoTrashFilter", "drop undoable step id=" + p3VarA.f11886m + " paths=" + x0.c(p3VarA) + " (trash not restorable)");
                        p3VarA = null;
                    }
                }
                if (p3VarA != null) {
                    arrayList2.add(p3VarA);
                }
            }
            if (!arrayList2.isEmpty()) {
                List listR = R(arrayList2);
                jb.g gVar = listR.isEmpty() ? new jb.g(kb.s.f7404c, 0) : listR.size() <= 3 ? new jb.g(listR, 0) : new jb.g(kb.l.J0(listR, 3), Integer.valueOf(listR.size() - 3));
                List list3 = (List) gVar.f6759c;
                int iIntValue = ((Number) gVar.f6760f).intValue();
                int size2 = list3.size() + iIntValue;
                p3 p3Var = (p3) kb.l.x0(list3);
                if (p3Var == null || (str = p3Var.f11877c) == null) {
                    p3 p3Var2 = (p3) kb.l.x0(arrayList2);
                    str = p3Var2 != null ? p3Var2.f11877c : j3Var.f11705h;
                }
                j3VarA = j3.a(j3Var, list3, iIntValue, size2, arrayList2, str, 865);
            }
            if (j3VarA != null) {
                arrayList.add(j3VarA);
            }
        }
        if (i == 0 && arrayList.size() == list.size()) {
            return tVar;
        }
        int size3 = arrayList.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj = arrayList.get(i3);
            i3++;
            size += ((j3) obj).f11702e.size();
        }
        int size4 = list.size();
        int size5 = arrayList.size();
        StringBuilder sbU = k0.a.u("removed=", i, " unrestorable undo steps taskGroups ", "->", size4);
        sbU.append(size5);
        sbU.append(" ops=");
        sbU.append(size);
        Log.i("UndoTrashFilter", sbU.toString());
        return t.a(tVar, size, null, arrayList, 14);
    }

    public static final Uri M(Context context, String str, b3 b3Var) {
        String str2;
        Uri uri;
        if (!B(context, b3Var)) {
            Log.w("RevokeMedia", "trash lookup skipped: no trash probe permission for kind=" + b3Var + " original=" + str);
            return null;
        }
        Uri contentUri = MediaStore.Files.getContentUri("external_primary");
        int iOrdinal = b3Var.ordinal();
        if (iOrdinal == 0) {
            str2 = "media_type = 1";
        } else if (iOrdinal == 1) {
            str2 = "media_type = 3";
        } else if (iOrdinal == 2) {
            str2 = "media_type = 2";
        } else {
            if (iOrdinal != 3) {
                g5.f.a();
                return null;
            }
            str2 = "media_type IN (6, 0)";
        }
        String str3 = str2;
        contentUri.getClass();
        Uri uriK = K(context, contentUri, str, b3Var, "Files", str3, true);
        if (uriK == null) {
            uriK = K(context, contentUri, str, b3Var, "Files", str3, false);
        }
        if (uriK == null) {
            if (b3Var == b3.f11467h) {
                uriK = K(context, contentUri, str, b3Var, "Files", null, true);
                if (uriK == null) {
                    uriK = K(context, contentUri, str, b3Var, "Files", null, false);
                }
            } else {
                uriK = null;
            }
        }
        if (uriK != null) {
            return uriK;
        }
        if (b3Var != b3.f11467h) {
            int iOrdinal2 = b3Var.ordinal();
            if (iOrdinal2 == 0) {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (iOrdinal2 == 1) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if (iOrdinal2 == 2) {
                uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            } else if (iOrdinal2 != 3) {
                g5.f.a();
                return null;
            }
            Uri uri2 = uri;
            int iOrdinal3 = b3Var.ordinal();
            String str4 = iOrdinal3 != 1 ? iOrdinal3 != 2 ? "Images" : "Audio" : "Video";
            uri2.getClass();
            Uri uriK2 = K(context, uri2, str, b3Var, str4, null, true);
            return uriK2 != null ? uriK2 : K(context, uri2, str, b3Var, str4, null, false);
        }
        return null;
    }

    public static final String N(p3 p3Var, Resources resources) throws Resources.NotFoundException {
        p3Var.getClass();
        List list = p3Var.C;
        u8.p pVar = p3Var.f11899z;
        String str = p3Var.f11894u;
        if (str == null || hc.h.g0(str)) {
            str = null;
        }
        if (pVar == u8.p.f14244f || !x0.b(p3Var).isEmpty()) {
            int size = x0.b(p3Var).size();
            String string = resources.getString(R.string.revoke_dialog_body_contact, Integer.valueOf(size >= 1 ? size : 1));
            string.getClass();
            return string;
        }
        if (pVar == u8.p.f14245g || !list.isEmpty()) {
            int size2 = list.size();
            String string2 = resources.getString(R.string.revoke_dialog_body_note, Integer.valueOf(size2 >= 1 ? size2 : 1));
            string2.getClass();
            return string2;
        }
        if (str != null) {
            return str;
        }
        String string3 = resources.getString(R.string.revoke_dialog_body_default);
        string3.getClass();
        return string3;
    }

    public static final String O(p3 p3Var) {
        p3Var.getClass();
        String str = p3Var.f11886m;
        if (!hc.h.g0(str)) {
            return str;
        }
        return "w:" + p3Var.f11875a.hashCode() + "|t:" + p3Var.f11877c;
    }

    public static String P(t3 t3Var) {
        t3Var.getClass();
        p3 p3Var = t3Var.f11984a;
        String string = hc.h.w0(p3Var.f11886m).toString();
        if (string.length() > 0) {
            return string;
        }
        String strO = x0.o(t3Var.f11986c);
        if (strO == null) {
            strO = "";
        }
        return hc.h.w0(strO).toString() + "|" + p3Var.f11895v + "|" + p3Var.f11875a;
    }

    public static jb.g Q(List list) {
        int iNextIndex;
        List listR = R(list);
        if (listR.isEmpty()) {
            return new jb.g(kb.s.f7404c, 0);
        }
        if (listR.size() <= 3) {
            return new jb.g(listR, 0);
        }
        ArrayList arrayList = new ArrayList(kb.l.J0(listR, 3));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listR) {
            p3 p3Var = (p3) obj;
            if (p3Var.f11880f && !arrayList.contains(p3Var)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return new jb.g(arrayList, Integer.valueOf(listR.size() - 3));
        }
        for (p3 p3Var2 : R(arrayList2)) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                }
                if (!((p3) listIterator.previous()).f11880f) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            if (iNextIndex < 0) {
                break;
            }
            arrayList.set(iNextIndex, p3Var2);
        }
        return new jb.g(R(arrayList), Integer.valueOf(listR.size() - 3));
    }

    public static final List R(List list) {
        r rVar = new r(7);
        a2.a0 a0Var = new a2.a0(5);
        a0Var.f32f = rVar;
        VarHandle.storeStoreFence();
        return kb.l.I0(list, a0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final s8.y2 S(s8.p3 r21, java.lang.String r22) {
        /*
            r0 = r21
            r0.getClass()
            java.lang.String r1 = r0.f11875a
            java.util.List r18 = s8.x0.b(r0)
            java.util.List r2 = r0.C
            java.lang.Object r3 = kb.l.x0(r18)
            u8.a r3 = (u8.a) r3
            u8.p r4 = r0.f11899z
            u8.p r5 = u8.p.f14244f
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L24
            boolean r5 = r18.isEmpty()
            if (r5 != 0) goto L22
            goto L24
        L22:
            r5 = r7
            goto L25
        L24:
            r5 = r6
        L25:
            u8.p r8 = u8.p.f14245g
            if (r4 == r8) goto L31
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L30
            goto L31
        L30:
            r6 = r7
        L31:
            java.lang.String r4 = O(r0)
            r7 = 0
            if (r5 != 0) goto L4d
            if (r6 == 0) goto L3b
            goto L4d
        L3b:
            if (r3 == 0) goto L4d
            java.lang.String r5 = r3.f14185a
            if (r5 == 0) goto L4d
            boolean r6 = hc.h.g0(r5)
            if (r6 != 0) goto L48
            goto L49
        L48:
            r5 = r7
        L49:
            if (r5 != 0) goto L4c
            goto L4d
        L4c:
            r1 = r5
        L4d:
            java.lang.String r5 = r0.f11894u
            if (r5 == 0) goto L5b
            boolean r6 = hc.h.g0(r5)
            if (r6 != 0) goto L58
            goto L59
        L58:
            r5 = r7
        L59:
            if (r5 != 0) goto L5d
        L5b:
            r5 = r22
        L5d:
            java.util.List r6 = r0.f11893t
            r8 = r7
            java.lang.String r7 = r0.f11889p
            r9 = r8
            java.util.List r8 = s8.x0.c(r0)
            r10 = r9
            java.lang.String r9 = r0.f11891r
            r11 = r10
            java.lang.String r10 = r0.f11892s
            r12 = r11
            java.lang.String r11 = r0.f11887n
            r13 = r12
            java.lang.String r12 = r0.f11888o
            r14 = r13
            java.lang.String r13 = r0.f11886m
            u8.p r0 = r0.f11899z
            if (r3 == 0) goto L85
            java.lang.String r15 = r3.f14185a
            if (r15 == 0) goto L85
            boolean r16 = hc.h.g0(r15)
            if (r16 != 0) goto L85
            goto L86
        L85:
            r15 = r14
        L86:
            if (r3 == 0) goto L9b
            java.util.List r14 = r3.f14186b
            if (r14 == 0) goto L9b
            java.lang.Object r14 = kb.l.x0(r14)
            java.lang.String r14 = (java.lang.String) r14
            if (r14 == 0) goto L9b
            java.lang.String r14 = G(r14)
            r16 = r14
            goto L9d
        L9b:
            r16 = 0
        L9d:
            if (r3 == 0) goto La6
            java.lang.String r3 = r3.f14187c
            r17 = r3
        La3:
            r19 = r2
            goto La9
        La6:
            r17 = 0
            goto La3
        La9:
            s8.y2 r2 = new s8.y2
            r20 = 1
            r14 = r0
            r3 = r4
            r4 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.g1.S(s8.p3, java.lang.String):s8.y2");
    }

    public static final int T(t tVar) {
        Object objPrevious;
        tVar.getClass();
        List list = tVar.f11965c;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((m1) objPrevious).f11794c) {
                break;
            }
        }
        m1 m1Var = (m1) objPrevious;
        if (m1Var != null) {
            int i = m1Var.f11796e;
            if (i < 0) {
                return 0;
            }
            return i;
        }
        int i3 = tVar.f11963a;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public static final ArrayList U(t tVar, Set set, long j10, boolean z10) {
        boolean zS;
        String strL;
        List list = tVar.f11966d;
        int iL = kb.x.L(kb.m.m0(list, 10));
        if (iL < 16) {
            iL = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
        for (Object obj : list) {
            linkedHashMap.put(((f2) obj).f11599a, obj);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        for (j3 j3Var : tVar.f11967e) {
            j3Var.getClass();
            long j11 = j3Var.i;
            if (j11 == j10 || j11 == 0) {
                for (p3 p3Var : j3Var.f11702e) {
                    if (z10) {
                        zS = x0.s(p3Var, j3Var, tVar, set);
                    } else {
                        DateTimeFormatter dateTimeFormatter = x0.f12068a;
                        p3Var.getClass();
                        set.getClass();
                        if (p3Var.f11880f) {
                            String strL2 = x0.l(p3Var, j3Var, tVar);
                            zS = (strL2 == null && (strL2 = x0.f(p3Var)) == null) ? true : !set.contains(strL2);
                        } else {
                            zS = false;
                        }
                    }
                    if (zS) {
                        if (z10) {
                            strL = x0.n(p3Var, j3Var, tVar);
                            if (strL == null) {
                                strL = x0.f(p3Var);
                            }
                        } else {
                            strL = x0.l(p3Var, j3Var, tVar);
                            if (strL == null) {
                                strL = x0.f(p3Var);
                            }
                        }
                        String str = strL;
                        if (str != null && linkedHashSet.add(str)) {
                            f2 f2Var = (f2) linkedHashMap.get(str);
                            if (f2Var == null) {
                                f2Var = new f2(str, p3Var.f11875a, p3Var.f11877c, null, j3Var.f11698a);
                            }
                            arrayList.add(f2Var);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static final String V(int i) {
        return i == 23 ? String.format(Locale.US, "%02d:00–24:00", Arrays.copyOf(new Object[]{23}, 1)) : String.format(Locale.US, "%02d:00–%02d:00", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i + 1)}, 2));
    }

    public static final long W(ZoneId zoneId) {
        return LocalDate.now(zoneId).atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public static final void a(String str, xb.a aVar, boolean z10, k0.s sVar, int i) {
        String str2;
        boolean z11;
        boolean z12;
        k0.s sVar2 = sVar;
        sVar2.Z(80430230);
        int i3 = i | (sVar2.f(str) ? 4 : 2) | (sVar2.h(aVar) ? 32 : 16) | (sVar2.g(z10) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar2.P(i3 & 1, (i3 & 147) != 146)) {
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarB);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(vVarA, sVar2, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar2, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar2, hVar4);
            float f5 = 16;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(l9.a.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), aVar), f5, f5);
            w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 48);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, mVarG);
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(r0VarA, sVar2, hVar);
            k0.z.B(gVarL2, sVar2, hVar2);
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar2, iHashCode2, hVar3);
            }
            k0.z.B(mVarM2, sVar2, hVar4);
            long j10 = x1.f12093t;
            h0.t1.b(str, null, j10, x1.M, g2.k.f4253h, 0L, null, x1.N, 0, false, 0, 0, null, sVar, (i3 & 14) | 200064, 6, 130002);
            t0.a.b(sVar, w.s0.a());
            l9.a.a(androidx.compose.foundation.layout.c.f(jVar, 20), j10, str, sVar, ((i3 << 6) & 896) | 54);
            str2 = str;
            sVar2 = sVar;
            sVar2.q(true);
            z11 = z10;
            if (z11) {
                sVar2.X(-124223301);
                l9.a.b(null, 0.0f, 0.0f, sVar2, 0, 7);
                z12 = false;
            } else {
                z12 = false;
                sVar2.X(-132719998);
            }
            sVar2.q(z12);
            sVar2.q(true);
        } else {
            str2 = str;
            z11 = z10;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            q2 q2Var = new q2(2);
            q2Var.f11906f = str2;
            q2Var.f11908h = aVar;
            q2Var.f11907g = z11;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = q2Var;
        }
    }

    public static final void b(xb.a aVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-1004405010);
        if ((i & 6) == 0) {
            i3 = (sVar.h(aVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = 1;
        if (sVar.P(i3 & 1, (i3 & 3) != 2)) {
            h0.q1.a(androidx.compose.foundation.a.e(androidx.compose.foundation.layout.c.a(x1.f12084k, x1.f12083j), false, null, aVar, 7), a0.e.a(x1.f12085l), x1.f12075d, 0L, 0.0f, 0.0f, f11616b, sVar, 12583296, 120);
        } else {
            sVar.S();
        }
        k0.v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            g gVar = new g(i10);
            gVar.f11609g = aVar;
            gVar.f11608f = i;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = gVar;
        }
    }

    public static final void c(List list, int i, List list2, int i3, xb.a aVar, xb.a aVar2, xb.l lVar, xb.l lVar2, xb.l lVar3, w0.m mVar, k0.s sVar, int i10) {
        xb.l lVar4 = lVar3;
        aVar.getClass();
        aVar2.getClass();
        lVar.getClass();
        lVar2.getClass();
        lVar4.getClass();
        sVar.Z(-2110872902);
        int i11 = i10 | (sVar.h(list) ? 4 : 2) | (sVar.d(i) ? 32 : 16) | (sVar.h(list2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.d(i3) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024) | (sVar.h(aVar) ? 16384 : 8192) | (sVar.h(aVar2) ? 131072 : 65536) | (sVar.h(lVar) ? 1048576 : 524288) | (sVar.h(lVar2) ? 8388608 : 4194304) | (sVar.h(lVar4) ? 67108864 : 33554432) | 805306368;
        if (sVar.P(i11 & 1, (306783379 & i11) != 306783378)) {
            boolean zIsEmpty = list.isEmpty();
            boolean z10 = !zIsEmpty;
            boolean z11 = list2.size() > 0;
            if (zIsEmpty && !z11) {
                k0.v1 v1VarS = sVar.s();
                if (v1VarS != null) {
                    r1 r1Var = new r1();
                    r1Var.f11916c = list;
                    r1Var.f11917f = i;
                    r1Var.f11918g = list2;
                    r1Var.f11919h = i3;
                    r1Var.i = aVar;
                    r1Var.f11920j = aVar2;
                    r1Var.f11921k = lVar;
                    r1Var.f11922l = lVar2;
                    r1Var.f11923m = lVar4;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = r1Var;
                    return;
                }
                return;
            }
            List listJ0 = kb.l.J0(list, C(list.size(), list2.size()).f12057a);
            List listJ02 = kb.l.J0(list2, C(list.size(), list2.size()).f12058b);
            boolean z12 = !zIsEmpty && z11;
            a0.d dVarA = a0.e.a(x1.f12077e);
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            long j10 = x1.f12071b;
            mVar = jVar;
            float f5 = 0;
            s1 s1Var = new s1();
            s1Var.f11945c = dVarA;
            s1Var.f11946f = z10;
            s1Var.f11947g = z12;
            s1Var.f11948h = z11;
            s1Var.i = i;
            s1Var.f11949j = list;
            s1Var.f11950k = aVar;
            s1Var.f11951l = listJ0;
            s1Var.f11952m = lVar;
            s1Var.f11953n = i3;
            s1Var.f11954o = list2;
            s1Var.f11955p = aVar2;
            s1Var.f11956q = listJ02;
            s1Var.f11957r = lVar2;
            s1Var.f11958s = lVar3;
            VarHandle.storeStoreFence();
            s0.c cVarD = s0.h.d(737839253, s1Var, sVar);
            lVar4 = lVar3;
            h0.q1.a(mVarB, dVarA, j10, 0L, f5, f5, cVarD, sVar, 12804480, 72);
        } else {
            sVar.S();
        }
        w0.m mVar2 = mVar;
        k0.v1 v1VarS2 = sVar.s();
        if (v1VarS2 != null) {
            t1 t1Var = new t1();
            t1Var.f11973c = list;
            t1Var.f11974f = i;
            t1Var.f11975g = list2;
            t1Var.f11976h = i3;
            t1Var.i = aVar;
            t1Var.f11977j = aVar2;
            t1Var.f11978k = lVar;
            t1Var.f11979l = lVar2;
            t1Var.f11980m = lVar4;
            t1Var.f11981n = mVar2;
            VarHandle.storeStoreFence();
            v1VarS2.f7091d = t1Var;
        }
    }

    public static final void d(f2 f2Var, xb.a aVar, k0.s sVar, int i) {
        k0.s sVar2 = sVar;
        sVar2.Z(-1450103299);
        int i3 = i | (sVar2.f(f2Var) ? 4 : 2) | (sVar2.h(aVar) ? 32 : 16);
        if (sVar2.P(i3 & 1, (i3 & 19) != 18)) {
            w0.j jVar = w0.j.f15113c;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(l9.a.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), aVar), 16, x1.f12079g);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarG);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(vVarA, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            h0.t1.b(f2Var.f11600b, null, x1.f12092s, x1.O, g2.k.f4253h, 0L, null, x1.P, 2, false, 2, 0, null, sVar, 200064, 3126, 119762);
            String str = f2Var.f11603e;
            String strO = f2Var.f11601c;
            String string = hc.h.w0(str).toString();
            if (string == null) {
                string = "";
            }
            if (string.length() == 0) {
                string = strO;
                h0.t1.b(string, androidx.compose.foundation.layout.b.j(jVar, 0.0f, x1.f12081h, 0.0f, 0.0f, 13), x1.f12093t, x1.Q, null, 0L, null, x1.R, 2, false, 1, 0, null, sVar, 3504, 3126, 119792);
                sVar2 = sVar;
                sVar2.q(true);
            } else {
                String string2 = hc.h.w0(hc.h.s0(strO, (char) 183)).toString();
                if (string2.length() == 0) {
                    string2 = hc.h.w0(hc.h.s0(strO, ' ')).toString();
                }
                if (string2.length() != 0) {
                    strO = k0.a.o(string2, " ", string);
                    string = strO;
                }
                h0.t1.b(string, androidx.compose.foundation.layout.b.j(jVar, 0.0f, x1.f12081h, 0.0f, 0.0f, 13), x1.f12093t, x1.Q, null, 0L, null, x1.R, 2, false, 1, 0, null, sVar, 3504, 3126, 119792);
                sVar2 = sVar;
                sVar2.q(true);
            }
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            j9.i iVar = new j9.i(8);
            iVar.f6671f = f2Var;
            iVar.f6672g = aVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = iVar;
        }
    }

    public static final void e(a3 a3Var, boolean z10, xb.a aVar, xb.l lVar, w0.m mVar, k0.s sVar, int i) {
        a3 a3Var2;
        boolean z11;
        xb.a aVar2;
        xb.l lVar2;
        k0.s sVar2;
        aVar.getClass();
        lVar.getClass();
        sVar.Z(-658322167);
        int i3 = 2;
        int i10 = i | (sVar.h(a3Var) ? 4 : 2) | (sVar.g(z10) ? 32 : 16) | (sVar.h(aVar) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128) | (sVar.h(lVar) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024);
        boolean z12 = false;
        if (sVar.P(i10 & 1, (i10 & 9363) != 9362)) {
            if (a3Var != null && !z10) {
                z12 = true;
            }
            p5.f.a(z12, aVar, sVar, (i10 >> 3) & 112);
            a3Var2 = a3Var;
            z11 = z10;
            aVar2 = aVar;
            lVar2 = lVar;
            sVar2 = sVar;
            x2.g(a3Var2, z11, aVar2, lVar2, mVar.d(androidx.compose.foundation.layout.c.f904c), sVar2, i10 & 8190);
        } else {
            a3Var2 = a3Var;
            z11 = z10;
            aVar2 = aVar;
            lVar2 = lVar;
            sVar2 = sVar;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            j9.c cVar = new j9.c(i3);
            cVar.f6650g = a3Var2;
            cVar.f6649f = z11;
            cVar.i = aVar2;
            cVar.f6651h = lVar2;
            cVar.f6652j = mVar;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = cVar;
        }
    }

    public static final void f(t3 t3Var, xb.a aVar, xb.a aVar2, k0.s sVar, int i) throws Resources.NotFoundException {
        k0.s sVar2 = sVar;
        sVar2.Z(1541993825);
        int i3 = i | (sVar2.h(t3Var) ? 4 : 2) | (sVar2.h(aVar) ? 32 : 16) | (sVar2.h(aVar2) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if (sVar2.P(i3 & 1, (i3 & 147) != 146)) {
            Resources resources = ((Context) sVar2.j(AndroidCompositionLocals_androidKt.f982b)).getResources();
            w0.j jVar = w0.j.f15113c;
            w0.m mVarG = androidx.compose.foundation.layout.b.g(l9.a.g(androidx.compose.foundation.layout.c.b(jVar, 1.0f), aVar), 16, x1.f12079g);
            w.r0 r0VarA = w.p0.a(w.k.f14990a, w0.b.f15098o, sVar2, 48);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarG);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            u1.h hVar = u1.i.f13836e;
            k0.z.B(r0VarA, sVar2, hVar);
            u1.h hVar2 = u1.i.f13835d;
            k0.z.B(gVarL, sVar2, hVar2);
            u1.h hVar3 = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar3);
            }
            u1.h hVar4 = u1.i.f13834c;
            k0.z.B(mVarM, sVar2, hVar4);
            w0.m mVarJ = androidx.compose.foundation.layout.b.j(w.s0.a(), 0.0f, 0.0f, x1.i, 0.0f, 11);
            w.v vVarA = w.u.a(w.k.f14992c, w0.b.f15100q, sVar2, 0);
            int iHashCode2 = Long.hashCode(sVar2.T);
            s0.g gVarL2 = sVar2.l();
            w0.m mVarM2 = t.o.m(sVar2, mVarJ);
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(vVarA, sVar2, hVar);
            k0.z.B(gVarL2, sVar2, hVar2);
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode2))) {
                k0.a.y(iHashCode2, sVar2, iHashCode2, hVar3);
            }
            k0.z.B(mVarM2, sVar2, hVar4);
            h0.t1.b(t3Var.f11984a.f11875a, null, x1.f12092s, x1.O, g2.k.f4253h, 0L, null, x1.P, 2, false, 2, 0, null, sVar, 200064, 3126, 119762);
            p3 p3Var = t3Var.f11984a;
            String str = t3Var.f11985b;
            resources.getClass();
            DateTimeFormatter dateTimeFormatter = x0.f12068a;
            String string = resources.getString(R.string.undo_home_subtitle, p3Var.f11877c, str);
            string.getClass();
            h0.t1.b(string, androidx.compose.foundation.layout.b.j(jVar, 0.0f, x1.f12081h, 0.0f, 0.0f, 13), x1.f12093t, x1.Q, null, 0L, null, x1.R, 2, false, 1, 0, null, sVar, 3504, 3126, 119792);
            sVar2 = sVar;
            sVar2.q(true);
            b(aVar2, sVar2, (i3 >> 6) & 14);
            sVar2.q(true);
        } else {
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            j9.n nVar = new j9.n(5);
            nVar.f6692f = t3Var;
            nVar.f6693g = aVar;
            nVar.f6694h = aVar2;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = nVar;
        }
    }

    public static t g(t tVar, Set set, Map map, Map map2, xb.l lVar) {
        tVar.getClass();
        set.getClass();
        if (set.isEmpty()) {
            return tVar;
        }
        List<j3> list = tVar.f11967e;
        ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
        for (j3 j3Var : list) {
            e9.k kVar = new e9.k(4);
            kVar.f3680h = set;
            kVar.f3679g = map;
            kVar.i = map2;
            kVar.f3678f = lVar;
            VarHandle.storeStoreFence();
            DateTimeFormatter dateTimeFormatter = x0.f12068a;
            j3Var.getClass();
            List list2 = j3Var.f11702e;
            ArrayList arrayList2 = new ArrayList(kb.m.m0(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(kVar.invoke(it.next()));
            }
            List list3 = j3Var.f11699b;
            ArrayList arrayList3 = new ArrayList(kb.m.m0(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList3.add(kVar.invoke(it2.next()));
            }
            arrayList.add(j3.a(j3Var, arrayList3, 0, 0, arrayList2, null, 1005));
        }
        return t.a(tVar, 0, null, arrayList, 15);
    }

    public static final k8.a h(d1 d1Var, ZoneId zoneId, LocalDate localDate, LocalDate localDate2) {
        d1Var.getClass();
        zoneId.getClass();
        localDate.getClass();
        long epochMilli = localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
        int iOrdinal = d1Var.ordinal();
        if (iOrdinal == 0) {
            return new k8.a(epochMilli, 0L, 0L, 12);
        }
        if (iOrdinal == 1) {
            return new k8.a(0L, localDate.minusDays(6L).atStartOfDay(zoneId).toInstant().toEpochMilli(), epochMilli, 2);
        }
        if (iOrdinal == 2) {
            return new k8.a(0L, localDate.minusDays(29L).atStartOfDay(zoneId).toInstant().toEpochMilli(), epochMilli, 2);
        }
        if (iOrdinal != 3) {
            g5.f.a();
            return null;
        }
        if (localDate2 != null) {
            localDate = localDate2;
        }
        return new k8.a(0L, localDate.atStartOfDay(zoneId).toInstant().toEpochMilli(), epochMilli, 2);
    }

    public static /* synthetic */ k8.a i(d1 d1Var, ZoneId zoneId) {
        LocalDate localDateNow = LocalDate.now(zoneId);
        localDateNow.getClass();
        return h(d1Var, zoneId, localDateNow, null);
    }

    public static final ArrayList j(LocalDate localDate, LocalDate localDate2, ZoneId zoneId, String str, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, LinkedHashMap linkedHashMap3) {
        long j10;
        Integer num;
        int iIntValue;
        String str2;
        LocalDate localDate3 = localDate2;
        zoneId.getClass();
        str.getClass();
        LocalDate localDatePlusDays = localDate.compareTo((Object) localDate2) > 0 ? localDate3 : localDate;
        lb.c cVarO = ac.a.o();
        while (true) {
            j10 = 1;
            if (localDatePlusDays.isAfter(localDate3)) {
                break;
            }
            LocalDate localDateWith = localDatePlusDays.with(TemporalAdjusters.lastDayOfMonth());
            localDateWith.getClass();
            if (localDateWith.compareTo((Object) localDate3) > 0) {
                localDateWith = localDate3;
            }
            ec.e eVar = new ec.e();
            eVar.f3756c = localDatePlusDays;
            eVar.f3757f = localDateWith;
            VarHandle.storeStoreFence();
            cVarO.add(eVar);
            localDatePlusDays = localDateWith.plusDays(1L);
            localDatePlusDays.getClass();
        }
        lb.c cVarK = ac.a.k(cVarO);
        ArrayList arrayList = new ArrayList(kb.m.m0(cVarK, 10));
        int i = 0;
        ListIterator listIterator = cVarK.listIterator(0);
        while (true) {
            lb.a aVar = (lb.a) listIterator;
            if (!aVar.hasNext()) {
                break;
            }
            ec.d dVar = (ec.d) aVar.next();
            LocalDate localDatePlusDays2 = (LocalDate) dVar.a();
            int iIntValue2 = i;
            int iIntValue3 = iIntValue2;
            int iIntValue4 = iIntValue3;
            while (!localDatePlusDays2.isAfter((ChronoLocalDate) dVar.b())) {
                long epochMilli = localDatePlusDays2.atStartOfDay(zoneId).toInstant().toEpochMilli();
                Integer num2 = (Integer) linkedHashMap.get(Long.valueOf(epochMilli));
                iIntValue2 += num2 != null ? num2.intValue() : 0;
                Integer num3 = (Integer) linkedHashMap2.get(Long.valueOf(epochMilli));
                iIntValue3 += num3 != null ? num3.intValue() : 0;
                Integer num4 = (Integer) linkedHashMap3.get(Long.valueOf(epochMilli));
                iIntValue4 += num4 != null ? num4.intValue() : 0;
                localDatePlusDays2 = localDatePlusDays2.plusDays(1L);
                j10 = 1;
            }
            arrayList.add(new jb.l(Integer.valueOf(iIntValue2), Integer.valueOf(iIntValue3), Integer.valueOf(iIntValue4)));
            j10 = j10;
            i = 0;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(((Number) ((jb.l) it.next()).f6769c).intValue());
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(((Number) ((jb.l) it.next()).f6769c).intValue());
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        boolean z10 = true;
        if (num == null || (iIntValue = num.intValue()) < 1) {
            iIntValue = 1;
        }
        ArrayList arrayListP0 = kb.l.P0(cVarK, arrayList);
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayListP0, 10));
        int size = arrayListP0.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListP0.get(i3);
            i3++;
            jb.g gVar = (jb.g) obj;
            ec.d dVar2 = (ec.d) gVar.f6759c;
            jb.l lVar = (jb.l) gVar.f6760f;
            int iIntValue5 = ((Number) lVar.f6769c).intValue();
            int iIntValue6 = ((Number) lVar.f6770f).intValue();
            int iIntValue7 = ((Number) lVar.f6771g).intValue();
            LocalDate localDate4 = (LocalDate) dVar2.b();
            boolean z11 = (localDate4.getYear() == localDate3.getYear() && localDate4.getMonth() == localDate3.getMonth()) ? z10 : false;
            long epochMilli2 = ((LocalDate) dVar2.a()).atStartOfDay(zoneId).toInstant().toEpochMilli();
            long epochMilli3 = localDate4.atStartOfDay(zoneId).toInstant().toEpochMilli();
            if (!z11 || hc.h.g0(str)) {
                str2 = localDate4.getMonthValue() + "月";
            } else {
                str2 = str;
            }
            float fP = iIntValue5 <= 0 ? 0.0f : p5.f.p(iIntValue5 / iIntValue, 0.0f, 1.0f);
            arrayList2.add(new m1(str2, fP, z11, epochMilli3, iIntValue5, iIntValue6, iIntValue7, epochMilli2, localDate4.getYear() + "年" + localDate4.getMonthValue() + "月"));
            localDate3 = localDate2;
            z10 = true;
        }
        return arrayList2;
    }

    public static final ArrayList k(t tVar, long j10, List list, List list2) {
        tVar.getClass();
        list.getClass();
        list2.getClass();
        if (list.size() != 24 || list2.size() != 24) {
            g5.f.s("Failed requirement.");
            return null;
        }
        List list3 = tVar.f11967e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list3) {
            long j11 = ((j3) obj).i;
            if (j11 == j10 || j11 == 0) {
                arrayList.add(obj);
            }
        }
        int[] iArr = new int[24];
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            Iterator it = ((j3) obj2).f11702e.iterator();
            while (it.hasNext()) {
                int iD = D(((p3) it.next()).f11877c);
                iArr[iD] = iArr[iD] + 1;
            }
        }
        int[] iArr2 = new int[24];
        Iterator it2 = tVar.f11966d.iterator();
        while (it2.hasNext()) {
            String strT0 = ((f2) it2.next()).f11601c;
            int iD0 = hc.h.d0(strT0, (char) 183, 0, 6);
            if (iD0 >= 0) {
                strT0 = hc.h.t0(iD0, strT0);
            }
            String string = hc.h.w0(strT0).toString();
            if (!hc.h.Y(string, ':')) {
                string = null;
            }
            if (string != null) {
                int iD2 = D(string);
                iArr2[iD2] = iArr2[iD2] + 1;
            }
        }
        int[] iArr3 = new int[24];
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj3 = arrayList.get(i3);
            i3++;
            for (p3 p3Var : ((j3) obj3).f11702e) {
                if (x0.t(p3Var)) {
                    int iD3 = D(p3Var.f11877c);
                    iArr3[iD3] = iArr3[iD3] + 1;
                }
            }
        }
        int i10 = iArr[0];
        int i11 = 1;
        while (true) {
            int i12 = iArr[i11];
            if (i10 < i12) {
                i10 = i12;
            }
            if (i11 == 23) {
                break;
            }
            i11++;
        }
        if (i10 < 1) {
            i10 = 1;
        }
        ec.g gVar = new ec.g(0, 23, 1);
        ArrayList arrayList2 = new ArrayList(kb.m.m0(gVar, 10));
        ec.a it3 = gVar.iterator();
        while (it3.f3752h) {
            int iNextInt = it3.nextInt();
            int i13 = iArr[iNextInt];
            arrayList2.add(new m1((String) list.get(iNextInt), i13 > 0 ? p5.f.p(i13 / i10, 0.0f, 1.0f) : 0.0f, true, j10, i13, iArr2[iNextInt], iArr3[iNextInt], (String) list2.get(iNextInt), 128));
        }
        return arrayList2;
    }

    public static final List l(List list, k8.a aVar, ZoneId zoneId) {
        kb.s sVar;
        String str;
        j3 j3VarA;
        list.getClass();
        zoneId.getClass();
        if (aVar != null) {
            list = t(list, aVar);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            sVar = kb.s.f7404c;
            if (!zHasNext) {
                break;
            }
            j3 j3Var = (j3) it.next();
            j3Var.getClass();
            List list2 = j3Var.f11702e;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                if (x0.t((p3) obj)) {
                    arrayList2.add(obj);
                }
            }
            List listR = R(arrayList2);
            if (listR.isEmpty()) {
                j3VarA = null;
            } else {
                List listR2 = R(listR);
                jb.g gVar = listR2.isEmpty() ? new jb.g(sVar, 0) : listR2.size() <= 3 ? new jb.g(listR2, 0) : new jb.g(kb.l.J0(listR2, 3), Integer.valueOf(listR2.size() - 3));
                List list3 = (List) gVar.f6759c;
                int iIntValue = ((Number) gVar.f6760f).intValue();
                p3 p3Var = (p3) kb.l.x0(listR);
                if (p3Var == null || (str = p3Var.f11877c) == null) {
                    str = j3Var.f11705h;
                }
                j3VarA = j3.a(j3Var, list3, iIntValue, listR.size(), listR, str, 865);
            }
            if (j3VarA != null) {
                arrayList.add(j3VarA);
            }
        }
        if (arrayList.isEmpty()) {
            return sVar;
        }
        q qVar = new q(1);
        qVar.f11901f = zoneId;
        VarHandle.storeStoreFence();
        a2.a0 a0Var = new a2.a0(6);
        a0Var.f32f = qVar;
        VarHandle.storeStoreFence();
        return kb.l.I0(arrayList, a0Var);
    }

    public static final boolean m(Context context, Uri uri) {
        Object objL;
        boolean z10;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                z10 = true;
            } else {
                z10 = false;
            }
            objL = Boolean.valueOf(z10);
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        Object obj = Boolean.FALSE;
        if (objL instanceof jb.h) {
            objL = obj;
        }
        return ((Boolean) objL).booleanValue();
    }

    public static final List n(d1 d1Var, List list, List list2, List list3, List list4) {
        d1Var.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        int iOrdinal = d1Var.ordinal();
        if (iOrdinal == 0) {
            return list;
        }
        if (iOrdinal == 1) {
            return list2;
        }
        if (iOrdinal == 2) {
            return list3;
        }
        if (iOrdinal == 3) {
            return list4;
        }
        g5.f.a();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List o(java.util.List r9, k8.a r10, java.time.ZoneId r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.g1.o(java.util.List, k8.a, java.time.ZoneId):java.util.List");
    }

    public static final ec.i p(k8.a aVar) {
        aVar.getClass();
        long j10 = aVar.f7274a;
        long j11 = aVar.f7277d;
        long j12 = aVar.f7276c;
        if (j12 != 0 && j11 != 0) {
            return new ec.i(j12, j11);
        }
        if (j10 > 0) {
            return new ec.i(j10, j10);
        }
        return null;
    }

    public static final long q(j3 j3Var, ZoneId zoneId) {
        j3Var.getClass();
        zoneId.getClass();
        long j10 = j3Var.i;
        return j10 != 0 ? j10 : LocalDate.now(zoneId).atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public static final List r(y2 y2Var) {
        String string;
        y2Var.getClass();
        List list = y2Var.f12129f;
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
        if (!arrayList2.isEmpty()) {
            return kb.l.L0(kb.l.N0(arrayList2));
        }
        String str = y2Var.f12128e;
        String str2 = null;
        if (str != null && (string = hc.h.w0(str).toString()) != null && string.length() > 0) {
            str2 = string;
        }
        return str2 != null ? ac.a.E(str2) : kb.s.f7404c;
    }

    public static final t s(List list) {
        list.getClass();
        kb.s sVar = kb.s.f7404c;
        return new t(0, 0, list, sVar, sVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.ArrayList t(java.util.List r21, k8.a r22) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.g1.t(java.util.List, k8.a):java.util.ArrayList");
    }

    public static final t u(t tVar, long j10, List list) {
        tVar.getClass();
        list.getClass();
        int i = 0;
        if (j10 == 0) {
            return t.a(tVar, 0, list, null, 27);
        }
        List list2 = tVar.f11967e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            long j11 = ((j3) obj).i;
            if (j11 == j10 || j11 == 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((j3) obj2).f11698a);
        }
        Set setO0 = kb.l.O0(arrayList2);
        List list3 = tVar.f11966d;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list3) {
            f2 f2Var = (f2) obj3;
            if (!setO0.contains(f2Var.f11603e)) {
                if (!arrayList.isEmpty()) {
                    int size2 = arrayList.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        Object obj4 = arrayList.get(i10);
                        i10++;
                        List list4 = ((j3) obj4).f11702e;
                        ArrayList arrayList4 = new ArrayList(kb.m.m0(list4, 10));
                        Iterator it = list4.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(((p3) it.next()).f11875a);
                        }
                        if (arrayList4.contains(f2Var.f11600b)) {
                        }
                    }
                }
            }
            arrayList3.add(obj3);
        }
        int size3 = arrayList.size();
        int size4 = 0;
        while (i < size3) {
            Object obj5 = arrayList.get(i);
            i++;
            size4 += ((j3) obj5).f11702e.size();
        }
        return new t(size4, arrayList3.size(), list, arrayList3, arrayList);
    }

    public static final File v(File file, String str, String str2, int i) {
        File[] fileArrListFiles;
        File fileV;
        File file2 = null;
        if (i <= 0 || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isFile() && yb.k.a(file3.getName(), str)) {
                if (str2.length() > 0) {
                    String absolutePath = file3.getAbsolutePath();
                    absolutePath.getClass();
                    if (hc.h.X(absolutePath, str2, true)) {
                        return file3;
                    }
                }
                if (file2 == null) {
                    file2 = file3;
                }
            }
            if (file3.isDirectory() && (fileV = v(file3, str, str2, i - 1)) != null) {
                return fileV;
            }
        }
        return file2;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File w(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.g1.w(java.lang.String):java.io.File");
    }

    public static final p1 x(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i < 10000) {
            return new p1(String.valueOf(i), null);
        }
        if (i < 1000000) {
            return new p1(String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(i / 1000.0d)}, 1)), "k");
        }
        return new p1(String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(i / 1000000.0d)}, 1)), "m");
    }

    public static final String y(LocalDate localDate) {
        return localDate.getYear() + "/" + localDate.getMonthValue() + "/" + localDate.getDayOfMonth();
    }

    public static final boolean z(Context context, p3 p3Var) {
        String string;
        String string2;
        Object objL;
        context.getClass();
        k8.d dVar = new k8.d(19);
        d2.y yVar = new d2.y(28);
        l9.d dVar2 = new l9.d(1);
        dVar2.f7772f = context;
        VarHandle.storeStoreFence();
        if (!x0.t(p3Var)) {
            return true;
        }
        String str = p3Var.f11891r;
        if (str != null && (string2 = hc.h.w0(str).toString()) != null) {
            if (string2.length() <= 0) {
                string2 = null;
            }
            if (string2 != null) {
                try {
                    objL = Uri.parse(string2);
                } catch (Throwable th) {
                    objL = id.c.l(th);
                }
                if (objL instanceof jb.h) {
                    objL = null;
                }
                Uri uri = (Uri) objL;
                if (uri != null && ((Boolean) dVar2.invoke(uri)).booleanValue()) {
                    return true;
                }
            }
        }
        String str2 = p3Var.f11892s;
        if (str2 != null && (string = hc.h.w0(str2).toString()) != null) {
            String str3 = string.length() > 0 ? string : null;
            if (str3 != null) {
                String strH = H(str3);
                if (strH == null ? false : t1.e.l(new File(strH))) {
                    return true;
                }
            }
        }
        List listC = x0.c(p3Var);
        if (!listC.isEmpty()) {
            if (listC.isEmpty()) {
                return true;
            }
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                Context context2 = context;
                if (t2.a.d(context2, (String) it.next(), p3Var.f11886m, dVar, yVar, dVar2)) {
                    context = context2;
                }
            }
            return true;
        }
        return false;
    }
}

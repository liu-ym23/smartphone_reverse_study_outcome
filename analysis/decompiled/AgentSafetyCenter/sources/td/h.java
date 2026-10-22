package td;

import ad.b0;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.NetworkRequest;
import android.os.LocaleList;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.widget.TextView;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.u;
import b0.a0;
import b0.q;
import b0.w;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.agentsafetycenter.R;
import d1.f0;
import d2.i0;
import d2.l0;
import f7.v;
import gc.l;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;
import k0.s;
import k0.v1;
import kb.m;
import o2.n;
import o2.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s1.e0;
import u1.i;
import u1.z;
import v1.a1;
import w0.j;
import xb.p;
import yb.k;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static g f13307a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f13308b = false;

    /* renamed from: c, reason: collision with root package name */
    public static i1.f f13309c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f13310d;

    public static l A(p pVar) {
        l lVar = new l();
        lVar.f4703h = m(lVar, lVar, pVar);
        return lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object B(androidx.room.u r13, nb.c r14, xb.l r15, boolean r16, boolean r17) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof s4.b
            if (r0 == 0) goto L14
            r0 = r14
            s4.b r0 = (s4.b) r0
            int r1 = r0.f11376j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f11376j = r1
        L12:
            r14 = r0
            goto L1a
        L14:
            s4.b r0 = new s4.b
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r0 = r14.i
            ob.a r6 = ob.a.f9351c
            int r1 = r14.f11376j
            r2 = 3
            r3 = 2
            r7 = 1
            if (r1 == 0) goto L4a
            if (r1 == r7) goto L46
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2f
            id.c.I(r0)
            return r0
        L2f:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r13)
            r13 = 0
            return r13
        L36:
            boolean r13 = r14.f11375h
            boolean r1 = r14.f11374g
            xb.l r3 = r14.f11373f
            androidx.room.u r4 = r14.f11372c
            id.c.I(r0)
            r12 = r13
            r11 = r1
            r10 = r3
            r8 = r4
            goto L8f
        L46:
            id.c.I(r0)
            return r0
        L4a:
            id.c.I(r0)
            boolean r0 = r13.o()
            if (r0 == 0) goto L75
            boolean r0 = r13.s()
            if (r0 == 0) goto L75
            boolean r0 = r13.p()
            if (r0 == 0) goto L75
            s4.c r0 = new s4.c
            r2 = 0
            r1 = r13
            r3 = r15
            r5 = r16
            r4 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r14.f11376j = r7
            java.lang.Object r13 = r13.w(r5, r0, r14)
            if (r13 != r6) goto L74
            goto La4
        L74:
            return r13
        L75:
            r5 = r16
            r4 = r17
            r14.f11372c = r13
            r14.f11373f = r15
            r14.f11374g = r5
            r14.f11375h = r4
            r14.f11376j = r3
            nb.g r3 = u(r13, r4, r14)
            if (r3 != r6) goto L8a
            goto La4
        L8a:
            r8 = r13
            r10 = r15
            r0 = r3
            r12 = r4
            r11 = r5
        L8f:
            nb.g r0 = (nb.g) r0
            s4.a r7 = new s4.a
            r9 = 0
            r7.<init>(r8, r9, r10, r11, r12)
            r13 = 0
            r14.f11372c = r13
            r14.f11373f = r13
            r14.f11376j = r2
            java.lang.Object r13 = kc.w.E(r0, r7, r14)
            if (r13 != r6) goto La5
        La4:
            return r6
        La5:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: td.h.B(androidx.room.u, nb.c, xb.l, boolean, boolean):java.lang.Object");
    }

    public static final long C(long j10, long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) + ((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) + ((int) (j11 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public static final Cursor D(u uVar, y4.e eVar, boolean z10) {
        uVar.getClass();
        uVar.a();
        uVar.b();
        Cursor cursorC = uVar.j().w().C(eVar);
        if (z10 && (cursorC instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorC;
            int count = abstractWindowedCursor.getCount();
            if ((abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) {
                try {
                    MatrixCursor matrixCursor = new MatrixCursor(cursorC.getColumnNames(), cursorC.getCount());
                    while (cursorC.moveToNext()) {
                        Object[] objArr = new Object[cursorC.getColumnCount()];
                        int columnCount = cursorC.getColumnCount();
                        for (int i = 0; i < columnCount; i++) {
                            int type = cursorC.getType(i);
                            if (type == 0) {
                                objArr[i] = null;
                            } else if (type == 1) {
                                objArr[i] = Long.valueOf(cursorC.getLong(i));
                            } else if (type == 2) {
                                objArr[i] = Double.valueOf(cursorC.getDouble(i));
                            } else if (type == 3) {
                                objArr[i] = cursorC.getString(i);
                            } else {
                                if (type != 4) {
                                    throw new IllegalStateException();
                                }
                                objArr[i] = cursorC.getBlob(i);
                            }
                        }
                        matrixCursor.addRow(objArr);
                    }
                    cursorC.close();
                    return matrixCursor;
                } finally {
                }
            }
        }
        return cursorC;
    }

    public static b4.b E(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j10;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            od.f.l("Cannot read metadata.");
            return null;
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                j10 = -1;
                break;
            }
            int i10 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j10 = byteBufferDuplicate.getInt() & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i10) {
                break;
            }
            i3++;
        }
        if (j10 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j10 - byteBufferDuplicate.position())));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j11 = byteBufferDuplicate.getInt() & 4294967295L;
            for (int i11 = 0; i11 < j11; i11++) {
                int i12 = byteBufferDuplicate.getInt();
                long j12 = byteBufferDuplicate.getInt() & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i12 || 1701669481 == i12) {
                    byteBufferDuplicate.position((int) (j12 + j10));
                    b4.b bVar = new b4.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.f1900h = byteBufferDuplicate;
                    bVar.f1897c = iPosition;
                    int i13 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f1898f = i13;
                    bVar.f1899g = ((ByteBuffer) bVar.f1900h).getShort(i13);
                    return bVar;
                }
            }
        }
        od.f.l("Cannot read metadata.");
        return null;
    }

    public static final jb.g F(Context context, String str) throws PackageManager.NameNotFoundException {
        Drawable applicationIcon;
        context.getClass();
        str.getClass();
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getPackageManager().getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
                applicationInfo.getClass();
                String string = applicationInfo.loadLabel(packageManager).toString();
                if (!hc.h.g0(string)) {
                    str = string;
                }
                try {
                    applicationIcon = packageManager.getApplicationIcon(applicationInfo);
                } catch (Exception unused) {
                    applicationIcon = null;
                }
                return new jb.g(str, applicationIcon);
            } catch (PackageManager.NameNotFoundException unused2) {
                return new jb.g(context.getString(R.string.screen_perception_app_uninstalled_hint), null);
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            String string2 = context.getString(R.string.screen_perception_app_uninstalled_hint);
            string2.getClass();
            return new jb.g(string2, null);
        }
    }

    public static final float G(long j10, float f5, o2.c cVar) {
        float fD;
        long jC = n.c(j10);
        if (o.a(jC, 4294967296L)) {
            if (cVar.T() <= 1.05d) {
                return cVar.m0(j10);
            }
            fD = n.d(j10) / n.d(cVar.E(f5));
        } else {
            if (!o.a(jC, 8589934592L)) {
                return Float.NaN;
            }
            fD = n.d(j10);
        }
        return fD * f5;
    }

    public static final long H(long j10) {
        return (Math.round(Float.intBitsToFloat((int) (j10 & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j10 >> 32))) << 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static gc.n I(p pVar) {
        gc.n nVar = new gc.n(0);
        nVar.f4705b = (pb.h) pVar;
        VarHandle.storeStoreFence();
        return nVar;
    }

    public static final void J(Spannable spannable, long j10, int i, int i3) {
        if (j10 != 16) {
            spannable.setSpan(new ForegroundColorSpan(f0.r(j10)), i, i3, 33);
        }
    }

    public static final void K(Spannable spannable, long j10, o2.c cVar, int i, int i3) {
        long jC = n.c(j10);
        if (o.a(jC, 4294967296L)) {
            spannable.setSpan(new AbsoluteSizeSpan(ac.a.Q(cVar.m0(j10)), false), i, i3, 33);
        } else if (o.a(jC, 8589934592L)) {
            spannable.setSpan(new RelativeSizeSpan(n.d(j10)), i, i3, 33);
        }
    }

    public static void L(TextView textView, int i) {
        if (i < 0) {
            od.f.b();
            return;
        }
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.List] */
    public static final void M(Spannable spannable, j2.b bVar, int i, int i3) {
        if (bVar != null) {
            ArrayList arrayList = new ArrayList(m.m0(bVar, 10));
            Iterator it = bVar.f6545c.iterator();
            while (it.hasNext()) {
                arrayList.add(((j2.a) it.next()).f6543a);
            }
            Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
            spannable.setSpan(new LocaleSpan(new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length))), i, i3, 33);
        }
    }

    public static final w0.m N(w0.m mVar, d2.g gVar, l0 l0Var, xb.l lVar, int i, boolean z10, int i3, int i10, g2.d dVar, List list, xb.l lVar2, xb.l lVar3) {
        TextAnnotatedStringElement textAnnotatedStringElement = new TextAnnotatedStringElement();
        textAnnotatedStringElement.f927c = gVar;
        textAnnotatedStringElement.f928f = l0Var;
        textAnnotatedStringElement.f929g = dVar;
        textAnnotatedStringElement.f930h = lVar;
        textAnnotatedStringElement.i = i;
        textAnnotatedStringElement.f931j = z10;
        textAnnotatedStringElement.f932k = i3;
        textAnnotatedStringElement.f933l = i10;
        textAnnotatedStringElement.f934m = list;
        textAnnotatedStringElement.f935n = lVar2;
        textAnnotatedStringElement.f936o = lVar3;
        VarHandle.storeStoreFence();
        return mVar.d(j.f15113c).d(textAnnotatedStringElement);
    }

    public static Bitmap O(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return (96 == bitmapDrawable.getBitmap().getWidth() && 96 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), 96, 96, true);
            }
            g5.f.s("bitmap is null");
            return null;
        }
        Rect bounds = drawable.getBounds();
        int i = bounds.left;
        int i3 = bounds.top;
        int i10 = bounds.right;
        int i11 = bounds.bottom;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, 96, 96);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i, i3, i10, i11);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void P(java.lang.String r7, java.lang.String r8, java.util.Map r9) {
        /*
            boolean r0 = td.h.f13310d
            if (r0 != 0) goto L5
            goto L45
        L5:
            boolean r0 = n6.a.f8775g     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L27
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L11
            r3 = r7
            goto L1e
        L11:
            ma.e r0 = ma.d.f8538a     // Catch: java.lang.Throwable -> L24
            ha.c r1 = r0.f8545g     // Catch: java.lang.Throwable -> L24
            com.stepos.agentsafetycenter.AgentSafetyApplication r2 = r0.f8539a     // Catch: java.lang.Throwable -> L24
            r6 = 1
            r3 = r7
            r4 = r8
            r5 = r9
            r1.a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L21
        L1e:
            jb.v r7 = jb.v.f6774a     // Catch: java.lang.Throwable -> L21
            goto L34
        L21:
            r0 = move-exception
        L22:
            r7 = r0
            goto L30
        L24:
            r0 = move-exception
            r3 = r7
            goto L22
        L27:
            r3 = r7
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L21
            java.lang.String r8 = "UsageStatsProxy3 is not initialised - invoke at least once with parameterised init"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L21
            throw r7     // Catch: java.lang.Throwable -> L21
        L30:
            jb.h r7 = id.c.l(r7)
        L34:
            java.lang.Throwable r7 = jb.i.b(r7)
            if (r7 == 0) goto L45
            java.lang.String r8 = "track failed event="
            java.lang.String r8 = r8.concat(r3)
            java.lang.String r9 = "UsageStatsTracker"
            android.util.Log.w(r9, r8, r7)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: td.h.P(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static Object Q(p pVar, Object obj, nb.c cVar) {
        pVar.getClass();
        nb.g context = cVar.getContext();
        Object dVar = context == nb.h.f8811c ? new ob.d(cVar) : new ob.e(cVar, context);
        x.c(2, pVar);
        return pVar.invoke(obj, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(d2.g r19, w0.m r20, d2.l0 r21, xb.l r22, int r23, boolean r24, int r25, int r26, java.util.Map r27, k0.s r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: td.h.a(d2.g, w0.m, d2.l0, xb.l, int, boolean, int, int, java.util.Map, k0.s, int, int):void");
    }

    public static final void b(String str, w0.m mVar, l0 l0Var, int i, boolean z10, int i3, int i10, s sVar, int i11) {
        int i12;
        sVar.Z(-1186827822);
        if ((i11 & 6) == 0) {
            i12 = (sVar.f(str) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= sVar.f(mVar) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= sVar.f(l0Var) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= sVar.h(null) ? RecyclerView.ItemAnimator.FLAG_MOVED : 1024;
        }
        if ((i11 & 24576) == 0) {
            i12 |= sVar.d(i) ? 16384 : 8192;
        }
        if ((196608 & i11) == 0) {
            i12 |= sVar.g(z10) ? 131072 : 65536;
        }
        if ((1572864 & i11) == 0) {
            i12 |= sVar.d(i3) ? 1048576 : 524288;
        }
        if ((12582912 & i11) == 0) {
            i12 |= sVar.d(i10) ? 8388608 : 4194304;
        }
        if (((i12 | 100663296) & 38347923) == 38347922 && sVar.B()) {
            sVar.S();
        } else {
            ac.a.j0(i10, i3);
            if (sVar.j(d0.b.f2949a) != null) {
                od.f.j();
                return;
            }
            sVar.X(-1588686502);
            sVar.q(false);
            sVar.X(-1587866335);
            w0.m mVarB = androidx.compose.ui.graphics.a.b(mVar, 0.0f, null, 131071);
            g2.d dVar = (g2.d) sVar.j(a1.f14365k);
            TextStringSimpleElement textStringSimpleElement = new TextStringSimpleElement();
            textStringSimpleElement.f937c = str;
            textStringSimpleElement.f938f = l0Var;
            textStringSimpleElement.f939g = dVar;
            textStringSimpleElement.f940h = i;
            textStringSimpleElement.i = z10;
            textStringSimpleElement.f941j = i3;
            textStringSimpleElement.f942k = i10;
            VarHandle.storeStoreFence();
            w0.m mVarD = mVarB.d(textStringSimpleElement);
            sVar.q(false);
            b0.b bVar = b0.b.f1714c;
            int iHashCode = Long.hashCode(sVar.T);
            w0.m mVarM = t.o.m(sVar, mVarD);
            s0.g gVarL = sVar.l();
            u1.j.f13840e.getClass();
            z zVar = i.f13833b;
            sVar.b0();
            if (sVar.S) {
                sVar.k(zVar);
            } else {
                sVar.l0();
            }
            k0.z.B(bVar, sVar, i.f13836e);
            k0.z.B(gVarL, sVar, i.f13835d);
            k0.z.B(mVarM, sVar, i.f13834c);
            u1.h hVar = i.f13837f;
            if (sVar.S || !k.a(sVar.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar, iHashCode, hVar);
            }
            sVar.q(true);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.e(str, mVar, l0Var, i, z10, i3, i10, i11);
        }
    }

    public static final long c(int i, int i3) {
        return (i3 & 4294967295L) | (i << 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0245  */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(w0.m r30, d2.g r31, xb.l r32, boolean r33, java.util.Map r34, d2.l0 r35, int r36, boolean r37, int r38, int r39, g2.d r40, xb.l r41, k0.s r42, int r43, int r44) {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: td.h.d(w0.m, d2.g, xb.l, boolean, java.util.Map, d2.l0, int, boolean, int, int, g2.d, xb.l, k0.s, int, int):void");
    }

    public static final c1.d e(float f5, float f10, float f11, float f12, long j10) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        long jFloatToRawIntBits = (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat2));
        return new c1.d(f5, f10, f11, f12, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits, jFloatToRawIntBits);
    }

    public static void f(Context context, String str, com.stepos.statsrpk.b bVar) throws JSONException {
        ua.c.a("RpkUxipConfig", "parseAppInfo");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + bVar.f2848c;
        ua.c.d("SharedPreferencesHelper", "init SharedPreferences, name: ".concat(str2));
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        ua.c.a("SharedPreferencesHelper", str2.concat(" structure complete"));
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!TextUtils.isEmpty(jSONObject.getString("key"))) {
            String string = jSONObject.getString("key");
            bVar.i = string;
            editorEdit.putString("appKey", string);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("primaryPackageName"))) {
            String string2 = jSONObject.getString("primaryPackageName");
            bVar.f2851h = string2;
            editorEdit.putString("apkPkgName", string2);
        }
        editorEdit.commit();
    }

    public static final ArrayList g(List list, xb.a aVar) {
        b0.z zVar;
        if (!((Boolean) aVar.invoke()).booleanValue()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            e0 e0Var = (e0) list.get(i);
            Object objV = e0Var.v();
            objV.getClass();
            q qVar = ((a0) objV).f1712c;
            b0.x xVar = qVar.f1776a;
            int i3 = qVar.f1777b;
            int i10 = qVar.f1778c;
            i0 i0Var = (i0) xVar.f1795b.getValue();
            if (i0Var == null) {
                zVar = new b0.z();
                zVar.f1801c = 0;
                zVar.f1802f = 0;
                zVar.f1803g = w.f1793c;
                VarHandle.storeStoreFence();
            } else {
                o2.j jVarU = a.a.U(i0Var.g(i3, i10).b());
                int i11 = jVarU.f9120c - jVarU.f9118a;
                int i12 = jVarU.f9121d - jVarU.f9119b;
                ad.l lVar = new ad.l(jVarU, 3);
                zVar = new b0.z();
                zVar.f1801c = i11;
                zVar.f1802f = i12;
                zVar.f1803g = lVar;
                VarHandle.storeStoreFence();
            }
            int i13 = zVar.f1801c;
            int i14 = zVar.f1802f;
            arrayList.add(new jb.g(e0Var.q(id.k.q(i13, i13, i14, i14)), (yb.l) zVar.f1803g));
        }
        return arrayList;
    }

    public static void h(Context context, String str, com.stepos.statsrpk.b bVar) throws JSONException {
        ua.c.a("RpkUxipConfig", "parseConfig");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + bVar.f2848c;
        ua.c.d("SharedPreferencesHelper", "init SharedPreferences, name: ".concat(str2));
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        ua.c.a("SharedPreferencesHelper", str2.concat(" structure complete"));
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("version", jSONObject.getInt("version"));
        editorEdit.putBoolean("active", jSONObject.getBoolean("active"));
        editorEdit.putString("getTime", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        editorEdit.commit();
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        String strConcat = "";
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("name");
            boolean z10 = jSONObject2.getBoolean("active");
            boolean z11 = jSONObject2.getBoolean("realtime");
            boolean z12 = jSONObject2.getBoolean("neartime");
            map.put(string, new pa.a(string, z10, z11, z12));
            int i3 = !z10 ? 0 : (z11 || z12) ? 2 : 1;
            if (!string.contains(":") && !string.contains(",")) {
                strConcat = strConcat + string + ":" + i3;
                if (i < jSONArray.length() - 1) {
                    strConcat = strConcat.concat(",");
                }
            }
        }
        editorEdit.putString("event_filters", strConcat);
        editorEdit.commit();
    }

    public static void i(int i, int i3, int i10) {
        if (i < 0 || i3 > i10) {
            b8.z.i(i10, k0.a.u("fromIndex: ", i, ", toIndex: ", ", size: ", i3));
        } else {
            if (i <= i3) {
                return;
            }
            g5.f.s(androidx.activity.b.i("fromIndex: ", i, " > toIndex: ", i3));
        }
    }

    public static int j(int i, int i3, int i10) {
        return i < i3 ? i3 : i > i10 ? i10 : i;
    }

    public static final aa.o k(aa.o oVar) {
        oVar.getClass();
        aa.o oVar2 = new aa.o();
        oVar2.f16058a = oVar.f16058a;
        return oVar2;
    }

    public static b0 l(String str, ad.s sVar) {
        str.getClass();
        Charset charset = hc.a.f5448a;
        if (sVar != null) {
            Pattern pattern = ad.s.f568d;
            Charset charsetA = sVar.a(null);
            if (charsetA == null) {
                try {
                    sVar = id.k.t(sVar + "; charset=utf-8");
                } catch (IllegalArgumentException unused) {
                    sVar = null;
                }
            } else {
                charset = charsetA;
            }
        }
        byte[] bytes = str.getBytes(charset);
        bytes.getClass();
        int length = bytes.length;
        bd.b.c(bytes.length, 0, length);
        b0 b0Var = new b0();
        b0Var.f436a = sVar;
        b0Var.f437b = length;
        b0Var.f438c = bytes;
        VarHandle.storeStoreFence();
        return b0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static nb.c m(nb.c cVar, nb.c cVar2, p pVar) {
        pVar.getClass();
        if (pVar instanceof pb.a) {
            return ((pb.a) pVar).create(cVar, cVar2);
        }
        nb.g context = cVar2.getContext();
        return context == nb.h.f8811c ? new ob.b(cVar2, cVar, pVar) : new ob.c(cVar2, context, pVar, cVar);
    }

    public static q5.d n(int[] iArr, int[] iArr2) {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i : iArr) {
            try {
                builder.addCapability(i);
            } catch (IllegalArgumentException e10) {
                g5.u uVarD = g5.u.d();
                String str = q5.d.f10083b;
                String str2 = q5.d.f10083b;
                String str3 = "Ignoring adding capability '" + i + '\'';
                if (uVarD.f4344a <= 5) {
                    Log.w(str2, str3, e10);
                }
            }
        }
        for (int i3 : iArr2) {
            builder.addTransportType(i3);
        }
        NetworkRequest networkRequestBuild = builder.build();
        networkRequestBuild.getClass();
        return new q5.d(networkRequestBuild);
    }

    public static final void o(x4.a aVar) {
        aVar.getClass();
        lb.c cVarO = ac.a.o();
        x4.c cVarK = aVar.K("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cVarK.G()) {
            try {
                cVarO.add(cVarK.z(0));
            } finally {
            }
        }
        t2.a.h(cVarK, null);
        ListIterator listIterator = ac.a.k(cVarO).listIterator(0);
        while (true) {
            lb.a aVar2 = (lb.a) listIterator;
            if (!aVar2.hasNext()) {
                return;
            }
            String str = (String) aVar2.next();
            if (hc.o.U(str, "room_fts_content_sync_", false)) {
                t0.a.d(aVar, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    public static final long p(long j10, boolean z10, int i, float f5) {
        int i3 = ((z10 || i == 2) && o2.a.e(j10)) ? o2.a.i(j10) : Reader.READ_DONE;
        if (o2.a.k(j10) != i3) {
            i3 = p5.f.q(com.stepos.statsrpk.h.e(f5), o2.a.k(j10), i3);
        }
        return id.k.q(0, i3, 0, o2.a.h(j10));
    }

    public static String q(char[] cArr, int i, k6.e eVar) {
        int i3;
        if (eVar == null) {
            i3 = 0;
        } else if (eVar.equals(k6.e.f7269c)) {
            cArr[i] = 'Z';
            i3 = 1;
        } else {
            cArr[i] = eVar.a() < 0 ? '-' : '+';
            n6.b.c(Math.abs(eVar.f7270a), i + 1, cArr, 2);
            cArr[i + 3] = ':';
            n6.b.c(Math.abs(eVar.f7271b), i + 4, cArr, 2);
            i3 = 6;
        }
        return new String(cArr, 0, i + i3);
    }

    public static final p5.j r(p5.p pVar) {
        pVar.getClass();
        return new p5.j(pVar.f9764a, pVar.f9782t);
    }

    public static ColorStateList s(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListU;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListU = id.k.u(resourceId, context)) == null) ? typedArray.getColorStateList(i) : colorStateListU;
    }

    public static final nb.g u(u uVar, boolean z10, pb.c cVar) {
        if (!uVar.o()) {
            pc.c cVar2 = uVar.f1628a;
            if (cVar2 != null) {
                return cVar2.f9952c;
            }
            k.f("coroutineScope");
            throw null;
        }
        if (cVar.getContext().get(androidx.room.z.f1655c) != null) {
            od.f.j();
            return null;
        }
        if (z10) {
            nb.g gVar = uVar.f1629b;
            if (gVar != null) {
                return gVar;
            }
            k.f("transactionContext");
            throw null;
        }
        pc.c cVar3 = uVar.f1628a;
        if (cVar3 != null) {
            return cVar3.f9952c;
        }
        k.f("coroutineScope");
        throw null;
    }

    public static int v(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            String strTextValue = jsonNode.textValue();
            if ("object".equals(strTextValue)) {
                return 1;
            }
            if ("array".equals(strTextValue)) {
                return 2;
            }
            if ("string".equals(strTextValue)) {
                return 3;
            }
            if ("number".equals(strTextValue)) {
                return 4;
            }
            if ("integer".equals(strTextValue)) {
                return 5;
            }
            if ("boolean".equals(strTextValue)) {
                return 6;
            }
            if ("any".equals(strTextValue)) {
                return 8;
            }
            if ("null".equals(strTextValue)) {
                return 7;
            }
        }
        return jsonNode.isArray() ? 10 : 9;
    }

    public static j6.e w() {
        j6.e eVar;
        String str = "Utils";
        HashMap map = j6.e.f6601b;
        int i = 0;
        while (true) {
            if (i >= 5) {
                str = "spUtils";
                break;
            }
            if (!Character.isWhitespace("Utils".charAt(i))) {
                break;
            }
            i++;
        }
        HashMap map2 = j6.e.f6601b;
        j6.e eVar2 = (j6.e) map2.get(str);
        if (eVar2 != null) {
            return eVar2;
        }
        synchronized (j6.e.class) {
            try {
                eVar = (j6.e) map2.get(str);
                if (eVar == null) {
                    eVar = new j6.e();
                    eVar.f6602a = p5.f.x().getSharedPreferences(str, 0);
                    map2.put(str, eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public static int x(JsonNode jsonNode, u9.d dVar) {
        if (jsonNode == null) {
            return 9;
        }
        switch (g8.f.f4381a[jsonNode.getNodeType().ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
            case 4:
                return 3;
            case 5:
                return jsonNode.isIntegralNumber() ? 5 : 4;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                return 9;
        }
    }

    public static nb.c y(nb.c cVar) {
        nb.c cVarIntercepted;
        cVar.getClass();
        pb.c cVar2 = cVar instanceof pb.c ? (pb.c) cVar : null;
        return (cVar2 == null || (cVarIntercepted = cVar2.intercepted()) == null) ? cVar : cVarIntercepted;
    }

    public static final boolean z(c1.d dVar) {
        long j10 = dVar.f2175e;
        return (j10 >>> 32) == (4294967295L & j10) && j10 == dVar.f2176f && j10 == dVar.f2177g && j10 == dVar.f2178h;
    }

    public abstract void t(v vVar, float f5, float f10);
}

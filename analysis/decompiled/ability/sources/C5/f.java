package C5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.material3.internal.CalendarModelKt;
import c3.AbstractC0872b;
import c3.AbstractC0873c;
import com.google.android.material.datepicker.C0900c;
import com.google.android.material.datepicker.MaterialCalendar;
import com.stepos.ability.R;
import com.stepos.policy.sdk.PolicyManager;
import com.stepos.policy.sdk.util.ReadClipboardUtils;
import com.stepos.policy.sdk.util.SocketHookUtil;
import stepos.support.v7.app.P;
import u1.C2031a;

/* loaded from: classes3.dex */
public final class f implements P {
    public static volatile f i;

    /* renamed from: a, reason: collision with root package name */
    public Object f302a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    public f() {
        Log.i("OpenIdManager", "OpenIdManager create");
        this.f302a = new b("udid");
        this.b = new b("oaid");
        this.d = new b("vaid");
        this.c = new b("aaid");
        this.e = new C2031a();
    }

    public static d b(Cursor cursor) {
        d dVar = new d(0);
        dVar.d = null;
        dVar.b = 0;
        dVar.c = System.currentTimeMillis() + CalendarModelKt.MillisecondsIn24Hours;
        if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.d = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.b = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.c = cursor.getLong(columnIndex3);
            }
        }
        return dVar;
    }

    public static final f c() {
        if (i == null) {
            synchronized (f.class) {
                try {
                    if (i == null) {
                        i = new f();
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public C4.a a(Context context) {
        C4.a aVar = (C4.a) this.f;
        if (aVar != null && aVar.b) {
            return aVar;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            for (int i6 = 0; i6 < 4; i6++) {
                c cVar = c.e[i6];
                ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(cVar.f299a, 0);
                String str = (providerInfoResolveContentProvider == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) ? null : providerInfoResolveContentProvider.packageName;
                if (!TextUtils.isEmpty(str)) {
                    C4.a aVar2 = new C4.a(str, cVar);
                    this.f = aVar2;
                    return aVar2;
                }
            }
        }
        return null;
    }

    public synchronized void d(Context context, C4.a aVar) {
        boolean z10;
        if (((e) this.g) == null && (z10 = aVar.b)) {
            String str = z10 ? ((c) aVar.c).d : null;
            String str2 = z10 ? ((c) aVar.c).c : null;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(str);
                e eVar = new e(0);
                this.g = eVar;
                context.registerReceiver(eVar, intentFilter, str2, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.content.Context r11, boolean r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.e
            r1 = r0
            u1.a r1 = (u1.C2031a) r1
            java.lang.Object r0 = r1.f6686a
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto L12
            if (r12 != 0) goto L12
            boolean r10 = r0.booleanValue()
            return r10
        L12:
            C4.a r12 = r10.a(r11)
            r2 = 0
            if (r12 == 0) goto L80
            boolean r12 = r12.b
            if (r12 == 0) goto L80
            C4.a r10 = r10.a(r11)
            if (r10 == 0) goto L7a
            boolean r12 = r10.b
            if (r12 == 0) goto L7a
            r3 = 0
            if (r12 == 0) goto L31
            java.lang.Object r10 = r10.c     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            C5.c r10 = (C5.c) r10     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = r10.b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            goto L32
        L31:
            r10 = r3
        L32:
            android.net.Uri r5 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            android.content.ContentResolver r4 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = "supported"
            java.lang.String[] r8 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r9 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r3 == 0) goto L6b
            C5.d r10 = b(r3)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            int r11 = r10.b     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r12 = 1000(0x3e8, float:1.401E-42)
            if (r12 != r11) goto L66
            java.lang.String r11 = "0"
            java.lang.Object r10 = r10.d     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            boolean r10 = r11.equals(r10)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            if (r10 == 0) goto L67
            goto L66
        L60:
            r0 = move-exception
            r10 = r0
            goto L74
        L63:
            r0 = move-exception
            r10 = r0
            goto L6e
        L66:
            r2 = 1
        L67:
            r3.close()
            goto L7a
        L6b:
            if (r3 == 0) goto L7a
            goto L73
        L6e:
            r10.getMessage()     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L7a
        L73:
            goto L67
        L74:
            if (r3 == 0) goto L79
            r3.close()
        L79:
            throw r10
        L7a:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)
            r1.f6686a = r10
        L80:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: C5.f.e(android.content.Context, boolean):boolean");
    }

    @Override // stepos.support.v7.app.P
    public void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        String str = (String) this.f302a;
        Context context = (Context) this.b;
        if (z11) {
            if (str.equals("1")) {
                SocketHookUtil.recoveryPlatform();
                ReadClipboardUtils.setAgreeReadClipBoard(ReadClipboardUtils.READ_CLIPBOARD_PERMISSION_AGREE);
                PolicyManager policyManager = PolicyManager.INSTANCE;
                policyManager.saveReadClipboardStatus(context);
                policyManager.saveAgreeStatus(context, 1);
            }
            PolicyManager.autoUploadRecord(context, (String) this.c, (String) this.d, (String) this.e, (String[]) this.f, (String) this.g, str);
        }
        ((P) this.h).onPermissionClick(dialogInterface, z10, z11);
    }

    public f(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0872b.d(context, MaterialCalendar.class.getCanonicalName(), R.attr.materialCalendarStyle).data, P2.a.f1076q);
        this.f302a = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(4, 0), context);
        this.g = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(2, 0), context);
        this.b = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(3, 0), context);
        this.c = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(5, 0), context);
        ColorStateList colorStateListA = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, 7);
        this.d = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(9, 0), context);
        this.e = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(8, 0), context);
        this.f = C0900c.c(typedArrayObtainStyledAttributes.getResourceId(10, 0), context);
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}

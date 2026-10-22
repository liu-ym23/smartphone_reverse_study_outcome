package B0;

import G1.y;
import K.InterfaceC0088u;
import K.S;
import K.q0;
import K.z0;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.widget.RunnableC0209k;
import androidx.room.A;
import androidx.room.E;
import androidx.viewpager.widget.ViewPager;
import d.C0527a;
import g.AbstractC0560a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import t0.J;

/* loaded from: classes.dex */
public final class c implements InterfaceC0088u, G1.p {

    /* renamed from: a, reason: collision with root package name */
    public Object f136a;

    /* renamed from: b, reason: collision with root package name */
    public Object f137b;

    public c(int i4) {
        if (i4 == 7) {
            this.f136a = new Rect();
            this.f137b = new Rect();
            return;
        }
        if (i4 != 9) {
            if (i4 != 10) {
                this.f136a = Choreographer.getInstance();
                this.f137b = Looper.myLooper();
                return;
            }
            return;
        }
        this.f136a = c.class.getSimpleName();
        this.f137b = new HashMap();
        a(new Y1.a(4));
        a(new Y1.a(7));
        a(new Y1.a(3));
        a(new Y1.a(5));
        a(new Y1.a(6));
        a(new Y1.a(1));
        a(new Y1.a(2));
        a(new Y1.a(0));
    }

    public static String b(String str, String str2, String str3, long j4, String str4) {
        try {
            byte[] bArrDigest = ((MessageDigest) Z1.b.f2161b.get()).digest((str4 + new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date()) + str3 + j4 + str2 + 5000007L + str).getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i4 : bArrDigest) {
                if (i4 < 0) {
                    i4 += 256;
                }
                String[] strArr = Z1.b.f2160a;
                stringBuffer.append(strArr[i4 / 16] + strArr[i4 % 16]);
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str, N0.a aVar, boolean z4) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        String str2 = aVar.f1451a;
        if (!z4) {
            str2 = ".temp" + str2;
        }
        sb.append(str2);
        return sb.toString();
    }

    public void a(Y1.a aVar) {
        ((HashMap) this.f137b).put(aVar.a(), aVar);
    }

    public File d(String str) {
        File file = new File(((Context) this.f136a).getCacheDir(), c(str, N0.a.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(((Context) this.f136a).getCacheDir(), c(str, N0.a.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    @Override // K.InterfaceC0088u
    public z0 e(View view, z0 z0Var) {
        z0 z0VarE = S.e(view, z0Var);
        if (z0VarE.f1023a.j()) {
            return z0VarE;
        }
        Rect rect = (Rect) this.f136a;
        rect.left = z0VarE.b();
        rect.top = z0VarE.d();
        rect.right = z0VarE.c();
        rect.bottom = z0VarE.a();
        int childCount = ((ViewPager) this.f137b).getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            z0 z0VarB = S.b(((ViewPager) this.f137b).getChildAt(i4), z0VarE);
            rect.left = Math.min(z0VarB.b(), rect.left);
            rect.top = Math.min(z0VarB.d(), rect.top);
            rect.right = Math.min(z0VarB.c(), rect.right);
            rect.bottom = Math.min(z0VarB.a(), rect.bottom);
        }
        int i5 = rect.left;
        int i6 = rect.top;
        int i7 = rect.right;
        int i8 = rect.bottom;
        q0 q0Var = new q0(z0VarE);
        q0Var.e(D.c.b(i5, i6, i7, i8));
        return q0Var.b();
    }

    public ArrayList f(String str) {
        E eD = E.d(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        ((A) this.f136a).assertNotSuspendingTransaction();
        Cursor cursorH = J.H((A) this.f136a, eD);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(cursorH.isNull(0) ? null : cursorH.getString(0));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public KeyListener g(KeyListener keyListener) {
        return (keyListener instanceof NumberKeyListener) ^ true ? ((Z.b) this.f137b).f2126a.r(keyListener) : keyListener;
    }

    public boolean h(String str) {
        E eD = E.d(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        ((A) this.f136a).assertNotSuspendingTransaction();
        Cursor cursorH = J.H((A) this.f136a, eD);
        try {
            boolean z4 = false;
            if (cursorH.moveToFirst()) {
                z4 = cursorH.getInt(0) != 0;
            }
            return z4;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // G1.p
    public Object i() {
        try {
            return y.f636a.a((Class) this.f136a);
        } catch (Exception e4) {
            throw new RuntimeException("Unable to create instance of " + ((Class) this.f136a) + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e4);
        }
    }

    public void j(AttributeSet attributeSet, int i4) {
        TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f136a).getContext().obtainStyledAttributes(attributeSet, AbstractC0560a.f12596i, i4, 0);
        try {
            boolean z4 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            ((Z.b) this.f137b).f2126a.n(z4);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public InputConnection k(InputConnection inputConnection, EditorInfo editorInfo) {
        Z.b bVar = (Z.b) this.f137b;
        if (inputConnection != null) {
            return bVar.f2126a.s(inputConnection, editorInfo);
        }
        bVar.getClass();
        return null;
    }

    public void l(H.g gVar) {
        int i4 = gVar.f674b;
        if (i4 == 0) {
            ((Handler) this.f137b).post(new H.a(0, this, (C0527a) this.f136a, gVar.f673a));
        } else {
            ((Handler) this.f137b).post(new android.support.v4.os.a(this, (C0527a) this.f136a, i4, 4));
        }
    }

    public File m(InputStream inputStream, N0.a aVar) throws IOException {
        File file = new File(((Context) this.f136a).getCacheDir(), c((String) this.f137b, aVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i4 = inputStream.read(bArr);
                    if (i4 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i4);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }

    public void n() {
        ((com.google.android.gms.common.api.internal.l) ((RunnableC0209k) this.f137b).f3117c).getClass();
        throw null;
    }

    public c(EditText editText) {
        this.f136a = editText;
        this.f137b = new Z.b(editText);
    }
}

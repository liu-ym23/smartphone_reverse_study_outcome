package androidx.appcompat.widget;

import ad.t;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.room.RoomDatabase;
import androidx.viewpager.widget.ViewPager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.fasterxml.jackson.databind.JavaType;
import com.google.gson.JsonIOException;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonToken;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k1.a;
import k1.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l implements v0.r, q2.b, q2.e, q2.m, xd.f {

    /* renamed from: g, reason: collision with root package name */
    public final Object f887g;
    public Object h;

    public /* synthetic */ l(Object obj, Object obj2) {
        this.f887g = obj;
        this.h = obj2;
    }

    @Override // xd.f
    public Object a(Object obj) {
        Charset charsetA;
        ad.t tVar = (ad.t) obj;
        d5.i iVar = (d5.i) this.f887g;
        t.a aVar = tVar.f171a;
        if (aVar == null) {
            sd.h hVarW = tVar.w();
            ad.l lVarO = tVar.o();
            if (lVarO == null || (charsetA = ad.l.a(lVarO)) == null) {
                charsetA = gc.a.f9106b;
            }
            aVar = new t.a(hVarW, charsetA);
            tVar.f171a = aVar;
        }
        iVar.getClass();
        k5.a aVar2 = new k5.a(aVar);
        aVar2.U0(Strictness.f5435b);
        try {
            Object objA = ((d5.u) this.h).a(aVar2);
            if (aVar2.R0() == JsonToken.f5479m) {
                return objA;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            tVar.close();
        }
    }

    @Override // q2.e
    public void b(q2.d dVar) {
        RoomDatabase roomDatabase = (RoomDatabase) this.f887g;
        roomDatabase.b();
        roomDatabase.c();
        try {
            ((q2.c) this.h).h(dVar);
            roomDatabase.p();
        } finally {
            roomDatabase.k();
        }
    }

    @Override // q2.m
    public void c(q2.l lVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f887g;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((q2.c) this.h).h(lVar);
            workDatabase_Impl.p();
        } finally {
            workDatabase_Impl.k();
        }
    }

    @Override // q2.b
    public ArrayList d(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f887g;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.b
    public void e(q2.a aVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f887g;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((q2.c) this.h).h(aVar);
            workDatabase_Impl.p();
        } finally {
            workDatabase_Impl.k();
        }
    }

    @Override // q2.b
    public boolean f(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f887g;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            boolean z = false;
            if (cursorM.moveToFirst()) {
                z = cursorM.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // v0.r
    public v0.m0 g(View view, v0.m0 m0Var) {
        ViewPager viewPager = (ViewPager) this.h;
        v0.m0 m0VarF = v0.e0.f(view, m0Var);
        if (m0VarF.f13309a.n()) {
            return m0VarF;
        }
        Rect rect = (Rect) this.f887g;
        rect.left = m0VarF.b();
        rect.top = m0VarF.d();
        rect.right = m0VarF.c();
        rect.bottom = m0VarF.a();
        int childCount = viewPager.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            v0.m0 m0VarB = v0.e0.b(viewPager.getChildAt(i10), m0VarF);
            rect.left = Math.min(m0VarB.b(), rect.left);
            rect.top = Math.min(m0VarB.d(), rect.top);
            rect.right = Math.min(m0VarB.c(), rect.right);
            rect.bottom = Math.min(m0VarB.a(), rect.bottom);
        }
        return m0VarF.f(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // q2.m
    public ArrayList h(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT name FROM workname WHERE work_spec_id=?");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f887g;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.e
    public Long i(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT long_value FROM Preference where `key`=?");
        lVarW.Y(1, str);
        RoomDatabase roomDatabase = (RoomDatabase) this.f887g;
        roomDatabase.b();
        Cursor cursorM = roomDatabase.m(lVarW);
        try {
            Long lValueOf = null;
            if (cursorM.moveToFirst() && !cursorM.isNull(0)) {
                lValueOf = Long.valueOf(cursorM.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.b
    public boolean j(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f887g;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            boolean z = false;
            if (cursorM.moveToFirst()) {
                z = cursorM.getInt(0) != 0;
            }
            return z;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    public void k() {
        synchronized (this.f887g) {
            ((LinkedHashMap) this.h).clear();
            lb.n nVar = lb.n.f10413a;
        }
    }

    public KeyListener l(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((k1.a) this.h).f9834a.getClass();
        if (keyListener instanceof k1.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new k1.e(keyListener);
    }

    public void m(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f887g).getContext().obtainStyledAttributes(attributeSet, g.a.f8928i, i10, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            p(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public k1.c n(InputConnection inputConnection, EditorInfo editorInfo) {
        k1.a aVar = (k1.a) this.h;
        if (inputConnection == null) {
            aVar.getClass();
            inputConnection = null;
        } else {
            a.C0098a c0098a = aVar.f9834a;
            c0098a.getClass();
            if (!(inputConnection instanceof k1.c)) {
                inputConnection = new k1.c(c0098a.f9835a, inputConnection, editorInfo);
            }
        }
        return (k1.c) inputConnection;
    }

    public void o(int i10) {
        synchronized (this.f887g) {
        }
    }

    public void p(boolean z) {
        k1.g gVar = ((k1.a) this.h).f9834a.f9836b;
        if (gVar.f9855c != z) {
            if (gVar.f9854b != null) {
                androidx.emoji2.text.d dVarA = androidx.emoji2.text.d.a();
                g.a aVar = gVar.f9854b;
                dVarA.getClass();
                mb.y.n(aVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = dVarA.f1928a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    dVarA.f1929b.remove(aVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            gVar.f9855c = z;
            if (z) {
                k1.g.a(gVar.f9853a, androidx.emoji2.text.d.a().b());
            }
        }
    }

    public b3.f q(JavaType javaType) {
        b3.f fVar;
        synchronized (this) {
            fVar = (b3.f) ((HashMap) this.f887g).get(new q3.r(javaType, false));
        }
        return fVar;
    }

    public b3.f r(Class cls) {
        b3.f fVar;
        synchronized (this) {
            fVar = (b3.f) ((HashMap) this.f887g).get(new q3.r((Class<?>) cls, false));
        }
        return fVar;
    }

    public l(int i10) {
        switch (i10) {
            case 4:
                this.f887g = new HashMap(64);
                this.h = new AtomicReference();
                break;
            default:
                this.f887g = new Object();
                this.h = new LinkedHashMap();
                break;
        }
    }

    public l(WorkDatabase_Impl workDatabase_Impl, int i10) {
        switch (i10) {
            case 7:
                this.f887g = workDatabase_Impl;
                this.h = new q2.c(workDatabase_Impl, 3);
                break;
            default:
                this.f887g = workDatabase_Impl;
                this.h = new q2.c(workDatabase_Impl, 0);
                break;
        }
    }

    public l(WorkDatabase workDatabase) {
        this.f887g = workDatabase;
        this.h = new q2.c(workDatabase);
    }

    public l(EditText editText) {
        this.f887g = editText;
        this.h = new k1.a(editText);
    }

    public l(ViewPager viewPager) {
        this.h = viewPager;
        this.f887g = new Rect();
    }
}

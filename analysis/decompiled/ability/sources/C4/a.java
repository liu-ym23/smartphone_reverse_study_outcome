package C4;

import D9.u;
import Va.A;
import Va.n;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.ability.voicewakeup.AmooWakeupStateStore;
import j1.C1593b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import stepos.support.v7.app.a0;
import stepos.support.v7.app.b0;
import stepos.support.v7.widget.ActionBarContextView;

/* loaded from: classes3.dex */
public class a implements AmooWakeupStateStore, A, ViewPropertyAnimatorListener {
    public static volatile a d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f290a;
    public boolean b;
    public Object c;

    public /* synthetic */ a(int i) {
        this.f290a = i;
    }

    public static a c() {
        if (d == null) {
            synchronized (C1593b.class) {
                try {
                    if (d == null) {
                        a aVar = new a(3);
                        C1593b.a().b(new H.g());
                        d = aVar;
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public void a(cc.dd.dd.cc.dd.dd.c cVar) {
        boolean zG;
        synchronized (this) {
            try {
                zG = g();
                if (!zG) {
                    this.b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zG) {
            return;
        }
        Iterator it = d().iterator();
        while (it.hasNext()) {
            ((T.c) it.next()).a(cVar);
        }
    }

    public boolean b() {
        ApmInsightInitConfig apmInsightInitConfig;
        if (!this.b || (apmInsightInitConfig = (ApmInsightInitConfig) this.c) == null) {
            return false;
        }
        return apmInsightInitConfig.enableNetMonitor();
    }

    public ArrayList d() {
        ArrayList arrayList;
        synchronized (((ArrayList) this.c)) {
            arrayList = new ArrayList((ArrayList) this.c);
            ((ArrayList) this.c).clear();
        }
        return arrayList;
    }

    public void e(cc.dd.dd.cc.dd.dd.c cVar) {
        boolean zG;
        synchronized (this) {
            try {
                zG = g();
                if (!zG) {
                    this.b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zG) {
            return;
        }
        Iterator it = d().iterator();
        while (it.hasNext()) {
            ((T.c) it.next()).b(cVar);
        }
    }

    @Override // Va.A
    public void f(n nVar, boolean z10) {
        b0 b0Var = (b0) this.c;
        if (this.b) {
            return;
        }
        this.b = true;
        b0Var.f6292a.dismissPopupMenus();
        a0 a0Var = b0Var.c;
        if (a0Var != null) {
            a0Var.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
        }
        this.b = false;
    }

    public boolean g() {
        boolean z10;
        synchronized (this) {
            z10 = this.b;
        }
        return z10;
    }

    public void h() {
        this.b = true;
    }

    public void i() {
        this.b = false;
    }

    @Override // com.stepos.ability.voicewakeup.AmooWakeupStateStore
    public synchronized boolean isEnabled() {
        return this.b;
    }

    public void j() {
        this.b = false;
    }

    public void k(byte b) {
        ((B1.b) this.c).l(String.valueOf(b));
    }

    public void l(char c) {
        B1.b bVar = (B1.b) this.c;
        bVar.h(bVar.b, 1);
        char[] cArr = (char[]) bVar.c;
        int i = bVar.b;
        bVar.b = i + 1;
        cArr[i] = c;
    }

    public void m(int i) {
        ((B1.b) this.c).l(String.valueOf(i));
    }

    @Override // Va.A
    public boolean n(n nVar) {
        a0 a0Var = ((b0) this.c).c;
        if (a0Var == null) {
            return false;
        }
        a0Var.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
        return true;
    }

    public void o(long j5) {
        ((B1.b) this.c).l(String.valueOf(j5));
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        this.b = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.c;
        if (this.b) {
            return;
        }
        if (actionBarContextView.f6411w == 2) {
            actionBarContextView.j();
        }
        ViewGroup viewGroup = actionBarContextView.e;
        if (viewGroup != null) {
            viewGroup.setTranslationY(0.0f);
        }
        actionBarContextView.f6411w = 0;
        actionBarContextView.f6413z = null;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        ViewGroup viewGroup = ((ActionBarContextView) this.c).e;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        this.b = false;
    }

    public void p(String v10) {
        k.f(v10, "v");
        ((B1.b) this.c).l(v10);
    }

    public void q(short s5) {
        ((B1.b) this.c).l(String.valueOf(s5));
    }

    public void r(String value) {
        byte b;
        k.f(value, "value");
        B1.b bVar = (B1.b) this.c;
        bVar.h(bVar.b, value.length() + 2);
        char[] cArr = (char[]) bVar.c;
        int i = bVar.b;
        int i6 = i + 1;
        cArr[i] = JsonFactory.DEFAULT_QUOTE_CHAR;
        int length = value.length();
        value.getChars(0, length, cArr, i6);
        int i10 = length + i6;
        int i11 = i6;
        while (i11 < i10) {
            char c = cArr[i11];
            byte[] bArr = u.b;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = value.length();
                for (int i12 = i11 - i6; i12 < length2; i12++) {
                    bVar.h(i11, 2);
                    char cCharAt = value.charAt(i12);
                    byte[] bArr2 = u.b;
                    if (cCharAt >= bArr2.length || (b = bArr2[cCharAt]) == 0) {
                        int i13 = i11 + 1;
                        ((char[]) bVar.c)[i11] = cCharAt;
                        i11 = i13;
                    } else {
                        if (b == 1) {
                            String str = u.f448a[cCharAt];
                            k.c(str);
                            bVar.h(i11, str.length());
                            str.getChars(0, str.length(), (char[]) bVar.c, i11);
                            int length3 = str.length() + i11;
                            bVar.b = length3;
                            i11 = length3;
                        } else {
                            char[] cArr2 = (char[]) bVar.c;
                            cArr2[i11] = '\\';
                            cArr2[i11 + 1] = (char) b;
                            i11 += 2;
                            bVar.b = i11;
                        }
                    }
                }
                bVar.h(i11, 1);
                ((char[]) bVar.c)[i11] = JsonFactory.DEFAULT_QUOTE_CHAR;
                bVar.b = i11 + 1;
                return;
            }
            i11++;
        }
        cArr[i10] = JsonFactory.DEFAULT_QUOTE_CHAR;
        bVar.b = i10 + 1;
    }

    public void s() {
    }

    @Override // com.stepos.ability.voicewakeup.AmooWakeupStateStore
    public synchronized boolean setEnabled(boolean z10) {
        boolean zCommit;
        try {
            zCommit = ((SharedPreferences) this.c).edit().putBoolean("amoo_enabled", z10).commit();
        } catch (RuntimeException e) {
            Log.e("AmooWakeupStateStorage", "Failed to persist amoo state", e);
            zCommit = false;
        }
        if (!zCommit) {
            z10 = this.b && z10;
        }
        this.b = z10;
        return zCommit;
    }

    public void t() {
    }

    public String toString() {
        switch (this.f290a) {
            case 5:
                return this.b ? "FALL_THROUGH" : String.valueOf(this.c);
            default:
                return super.toString();
        }
    }

    public a() {
        this.f290a = 4;
        this.b = false;
        this.c = new ArrayList();
    }

    public a(String str, C5.c cVar) {
        this.f290a = 1;
        this.c = cVar;
        this.b = !TextUtils.isEmpty(str);
    }

    public a(B1.b bVar) {
        this.f290a = 2;
        this.c = bVar;
        this.b = true;
    }

    public a(Context context) {
        this.f290a = 0;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("voice_wakeup_amoo_state", 0);
        k.e(sharedPreferences, "getSharedPreferences(...)");
        this.c = sharedPreferences;
        this.b = sharedPreferences.getBoolean("amoo_enabled", true);
    }

    public a(List descriptors, boolean z10) {
        this.f290a = 9;
        k.f(descriptors, "descriptors");
        this.c = descriptors;
        this.b = z10;
    }

    public a(Object obj, boolean z10) {
        this.f290a = 5;
        this.c = obj;
        this.b = z10;
    }

    public a(b0 b0Var) {
        this.f290a = 7;
        this.c = b0Var;
    }

    public a(ActionBarContextView actionBarContextView) {
        this.f290a = 8;
        this.c = actionBarContextView;
        this.b = false;
    }
}

package fa;

import C4.h;
import D7.N;
import D9.n;
import E4.e;
import O7.i;
import T8.f;
import T8.g;
import Ua.b;
import V7.c;
import X8.A;
import X8.M;
import X8.U;
import X8.w;
import Z7.t;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.stepos.ability.voicewakeup.service.WakeupEnvironment;
import com.stepos.taskrobot.logger.LogAdapter;
import com.stepos.taskrobot.logger.Printer;
import h8.InterfaceC1507O;
import ha.C1548d;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import kotlin.Result;
import kotlin.jvm.internal.k;
import m8.C1682b;
import n8.AbstractC1744c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import q8.x;
import stepos.support.v7.app.AbstractC1975y;
import stepos.support.v7.app.C1970t;
import u1.C2031a;
import v8.C2065a;
import v8.C2068d;
import x.d;
import x.j;
import x.l;
import x.p;
import z8.C2195g;

/* renamed from: fa.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1449a implements c, WakeupEnvironment, Printer, x, b, j, g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4448a;
    public Object b;
    public Object c;

    public /* synthetic */ C1449a(int i, Object obj, Object obj2) {
        this.f4448a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // Ua.b
    public boolean a(Ua.c cVar, Menu menu) {
        return ((b) this.b).a(cVar, menu);
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void addAdapter(LogAdapter logAdapter) {
        ArrayList arrayList = (ArrayList) this.c;
        logAdapter.getClass();
        arrayList.add(logAdapter);
    }

    @Override // Ua.b
    public boolean b(Ua.c cVar, Menu menu) {
        return ((b) this.b).b(cVar, menu);
    }

    @Override // x.j
    public n c(Context context) {
        j jVar = (j) this.b;
        if (jVar != null && !((Boolean) ((d) this.c).b(new Object[0])).booleanValue()) {
            return jVar.c(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new u1.d(context, intent, new l(this, context)).j();
        n nVar = new n();
        nVar.f443a = str;
        return nVar;
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void clearLogAdapters() {
        ((ArrayList) this.c).clear();
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void d(String str, Object... objArr) {
        k(3, null, str, objArr);
    }

    @Override // T8.g
    public f e(G8.b classId) {
        k.f(classId, "classId");
        C2031a c2031a = (C2031a) this.b;
        C2195g c2195g = (C2195g) this.c;
        k.f(c2195g.c().c, "<this>");
        C1682b c1682bV = Z6.k.v(c2031a, classId, F8.f.g);
        if (c1682bV == null) {
            return null;
        }
        AbstractC1744c.a(c1682bV.f5307a).equals(classId);
        return c2195g.f(c1682bV);
    }

    @Override // Ua.b
    public boolean f(Ua.c cVar, MenuItem menuItem) {
        return ((b) this.b).f(cVar, menuItem);
    }

    @Override // x.j
    public boolean g(Context context) {
        j jVar = (j) this.b;
        if (context == null) {
            return false;
        }
        Boolean bool = (Boolean) ((d) this.c).b(context);
        return (jVar == null || bool.booleanValue()) ? bool.booleanValue() : jVar.g(context);
    }

    @Override // V7.b
    public Object getValue(Object obj, t property) {
        k.f(property, "property");
        return Float.valueOf(((A5.c) this.c).t((String) this.b));
    }

    public String h() {
        Object obj;
        String strW = "0";
        if (!TextUtils.isEmpty((String) this.b) && !"0".equals((String) this.b)) {
            obj = this.b;
        } else if (TextUtils.isEmpty((String) this.c) || "0".equals((String) this.c)) {
            String strR = com.apm.insight.g.a().r();
            this.b = strR;
            if (TextUtils.isEmpty(strR) || "0".equals((String) this.b)) {
                u1.d dVarB = u1.d.B();
                dVarB.getClass();
                try {
                    strW = M.a.w(((File) dVarB.c).getAbsolutePath());
                } catch (Throwable unused) {
                }
                this.c = strW;
                return strW;
            }
            obj = this.b;
        } else {
            obj = this.c;
        }
        return (String) obj;
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEnvironment
    public boolean hasAnyUserModel() {
        return ((e) this.c).b();
    }

    public U i(C2065a c2065a) {
        U uR;
        A a3 = c2065a.g;
        return (a3 == null || (uR = U7.a.R(a3)) == null) ? (Z8.g) ((C7.f) this.b).getF4884a() : uR;
    }

    @Override // com.stepos.ability.voicewakeup.service.WakeupEnvironment
    public boolean isEnabled() {
        Context context = (Context) this.b;
        k.f(context, "context");
        return Settings.Global.getInt(context.getContentResolver(), "voice_wakeup_enabled", 0) == 1;
    }

    public w j(InterfaceC1507O typeParameter, C2065a typeAttr) {
        k.f(typeParameter, "typeParameter");
        k.f(typeAttr, "typeAttr");
        return (w) ((W8.e) this.c).invoke(new M(typeParameter, typeAttr));
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void json(String str) {
        if (str == null || str.length() == 0) {
            d("Empty/Null json content");
            return;
        }
        try {
            String strTrim = str.trim();
            if (strTrim.startsWith("{")) {
                d(new JSONObject(strTrim).toString(2));
            } else if (strTrim.startsWith("[")) {
                d(new JSONArray(strTrim).toString(2));
            } else {
                e(null, "Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            e(null, "Invalid Json", new Object[0]);
        }
    }

    public synchronized void k(int i, Throwable th, String str, Object... objArr) {
        str.getClass();
        ThreadLocal threadLocal = (ThreadLocal) this.b;
        String str2 = (String) threadLocal.get();
        if (str2 != null) {
            threadLocal.remove();
        } else {
            str2 = null;
        }
        if (objArr != null && objArr.length != 0) {
            str = String.format(str, objArr);
        }
        log(i, str2, str, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public kotlin.collections.builders.SetBuilder l(kotlin.reflect.jvm.internal.impl.types.a r17, java.util.List r18, v8.C2065a r19) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fa.C1449a.l(kotlin.reflect.jvm.internal.impl.types.a, java.util.List, v8.a):kotlin.collections.builders.SetBuilder");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.stepos.ability.voicewakeup.service.a] */
    @Override // com.stepos.ability.voicewakeup.service.WakeupEnvironment
    public List loadableWords() {
        Object objA;
        Context context = (Context) this.b;
        List<C4.g> listE = N.E(context);
        ArrayList arrayList = new ArrayList();
        for (C4.g gVar : listE) {
            String wordId = gVar.f296a;
            k.f(wordId, "wordId");
            String string = context.getApplicationContext().getSharedPreferences("voice_wakeup_active_word", 0).getString("keyphrase_".concat(wordId), null);
            String str = (string == null || string.length() <= 0) ? null : string;
            if (str != null) {
                File fileA = ((e) this.c).a(wordId);
                if (fileA.exists() && fileA.length() != 0) {
                    byte[] bArrV = i.V(fileA);
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArrV.length);
                    byteBufferAllocateDirect.put(bArrV);
                    byteBufferAllocateDirect.rewind();
                    try {
                        E4.a.f472a.a(context);
                        ByteBuffer byteBufferDuplicate = byteBufferAllocateDirect.duplicate();
                        k.e(byteBufferDuplicate, "duplicate(...)");
                        objA = Integer.valueOf(E4.b.c(byteBufferDuplicate));
                    } catch (Throwable th) {
                        objA = kotlin.b.a(th);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = 0;
                    }
                    int iIntValue = ((Number) objA).intValue();
                    if (iIntValue < 1) {
                        iIntValue = 1;
                    }
                    int[] iArr = new int[iIntValue];
                    int i = 0;
                    while (i < iIntValue) {
                        int i6 = i + 1;
                        iArr[i] = i6;
                        i = i6;
                    }
                    int i10 = gVar.e;
                    int i11 = gVar.f;
                    numValueOf = iIntValue != 0 ? Integer.valueOf(iArr[0]) : null;
                    int iIntValue2 = numValueOf != null ? numValueOf.intValue() : 1;
                    byte[] bArr = new byte[8916];
                    M.a.q0(bArr, 0, 0);
                    M.a.q0(bArr, 4, 8888);
                    M.a.q0(bArr, 8, 2);
                    M.a.q0(bArr, 12, 3);
                    M.a.U(bArr, 16, 1, i10, iIntValue2);
                    M.a.U(bArr, TypedValues.Custom.TYPE_BOOLEAN, 2, i11, iIntValue2);
                    M.a.U(bArr, 1792, 4, i11, iIntValue2);
                    M.a.q0(bArr, 8896, 1);
                    M.a.q0(bArr, 8900, 12);
                    M.a.q0(bArr, 8904, 2);
                    M.a.q0(bArr, 8908, 1750);
                    M.a.q0(bArr, 8912, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    Iterator it = ((List) h.e.getF4884a()).iterator();
                    int i12 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i12 = -1;
                            break;
                        }
                        if (k.b(((C4.g) it.next()).f296a, wordId)) {
                            break;
                        }
                        i12++;
                    }
                    if (i12 < 0) {
                        i12 = 0;
                    }
                    String absolutePath = fileA.getAbsolutePath();
                    k.e(absolutePath, "getAbsolutePath(...)");
                    numValueOf = new com.stepos.ability.voicewakeup.service.a(gVar, str, absolutePath, i12, iArr, bArr);
                }
            }
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return arrayList;
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public synchronized void log(int i, String str, String str2, Throwable th) {
        if (th != null && str2 != null) {
            try {
                str2 = str2 + " : " + M.a.e0(th);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (th != null && str2 == null) {
            str2 = M.a.e0(th);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "Empty/NULL log message";
        }
        Iterator it = ((ArrayList) this.c).iterator();
        while (it.hasNext()) {
            LogAdapter logAdapter = (LogAdapter) it.next();
            if (logAdapter.isLoggable(i, str)) {
                logAdapter.log(i, str, str2);
            }
        }
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public Printer t(String str) {
        if (str != null) {
            ((ThreadLocal) this.b).set(str);
        }
        return this;
    }

    public String toString() {
        switch (this.f4448a) {
            case 0:
                StringBuilder sb = new StringBuilder("<");
                androidx.constraintlayout.core.dsl.a.z(sb, C1449a.class, " (type=");
                sb.append((CommentType) this.c);
                sb.append(", value=");
                return B7.a.q(sb, (String) this.b, ")>");
            default:
                return super.toString();
        }
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void v(String str, Object... objArr) {
        k(2, null, str, objArr);
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void w(String str, Object... objArr) {
        k(5, null, str, objArr);
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void wtf(String str, Object... objArr) {
        k(7, null, str, objArr);
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void xml(String str) throws TransformerException, IllegalArgumentException {
        if (str == null || str.length() == 0) {
            d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            e(null, "Invalid xml", new Object[0]);
        }
    }

    public /* synthetic */ C1449a(int i, Object obj, boolean z10, Object obj2) {
        this.f4448a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void d(Object obj) {
        k(3, null, obj == null ? "null" : !obj.getClass().isArray() ? obj.toString() : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object", new Object[0]);
    }

    public C1449a(p pVar) {
        this.f4448a = 10;
        this.c = new d(5);
        this.b = pVar;
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void i(String str, Object... objArr) {
        k(4, null, str, objArr);
    }

    public C1449a(C2068d c2068d) {
        this.f4448a = 4;
        W8.i iVar = new W8.i("Type parameter upper bound erasure results");
        this.b = kotlin.a.a(new I8.e(this, 11));
        this.c = iVar.c(new J4.b(this, 9));
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void e(String str, Object... objArr) {
        e(null, str, objArr);
    }

    @Override // com.stepos.taskrobot.logger.Printer
    public void e(Throwable th, String str, Object... objArr) {
        k(6, th, str, objArr);
    }

    public C1449a(Object obj) {
        this.f4448a = 3;
        this.b = obj;
        this.c = Thread.currentThread();
    }

    public C1449a(Context context, e modelStore) {
        this.f4448a = 6;
        k.f(modelStore, "modelStore");
        this.b = context;
        this.c = modelStore;
    }

    public C1449a(C1548d c1548d) {
        this.f4448a = 0;
        Mark mark = c1548d.f4594a;
        String str = c1548d.d;
        CommentType commentType = c1548d.c;
        this.b = str;
        this.c = commentType;
    }

    public C1449a(int i) {
        this.f4448a = i;
        switch (i) {
            case 7:
                this.b = new ThreadLocal();
                this.c = new ArrayList();
                break;
            case 11:
                break;
            default:
                this.b = new ArrayList();
                this.c = new ArrayList();
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, stepos.support.v7.app.l] */
    @Override // Ua.b
    public void d(Ua.c cVar) {
        ((b) this.b).d(cVar);
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.c;
        if (abstractC1975y.f6366v != null) {
            abstractC1975y.b.getDecorView().removeCallbacks(abstractC1975y.f6367w);
        }
        if (abstractC1975y.u != null) {
            abstractC1975y.t();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(abstractC1975y.u).alpha(0.0f);
            abstractC1975y.f6368x = viewPropertyAnimatorCompatAlpha;
            viewPropertyAnimatorCompatAlpha.setListener(new C1970t(this, 2));
        }
        abstractC1975y.e.onSupportActionModeFinished(abstractC1975y.f6365t);
        abstractC1975y.f6365t = null;
    }

    public C1449a(Map map) {
        this.f4448a = 8;
        this.b = map;
        this.c = new W8.i("Java nullability annotation states").d(new J4.b(this, 18));
    }
}

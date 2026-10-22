package y8;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.VarHandle;
import org.json.JSONException;
import t.c1;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f15937a;

    /* renamed from: b, reason: collision with root package name */
    public String f15938b;

    /* renamed from: c, reason: collision with root package name */
    public Context f15939c;

    /* renamed from: d, reason: collision with root package name */
    public volatile e f15940d;

    public final e a() throws JSONException, IOException {
        String strB = b(this.f15937a);
        String strB2 = b(this.f15938b);
        m mVarP = i1.p(strB, w.f16013g);
        if (!(mVarP instanceof l)) {
            if (mVarP instanceof k) {
                od.f.e("seed rules must be Updated, got NotModified");
                return null;
            }
            g5.f.a();
            return null;
        }
        y yVar = ((l) mVarP).f15978a;
        m mVarP2 = i1.p(strB2, w.f16014h);
        if (!(mVarP2 instanceof l)) {
            if (mVarP2 instanceof k) {
                od.f.e("seed grants must be Updated, got NotModified");
                return null;
            }
            g5.f.a();
            return null;
        }
        y yVar2 = ((l) mVarP2).f15978a;
        e eVar = new e();
        eVar.f15959a = yVar;
        eVar.f15960b = yVar2;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public final String b(String str) throws IOException {
        try {
            InputStream inputStreamOpen = this.f15939c.getAssets().open(str);
            inputStreamOpen.getClass();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, hc.a.f5448a), 8192);
            try {
                String strJ = c1.j(bufferedReader);
                bufferedReader.close();
                return strJ;
            } finally {
            }
        } catch (IOException e10) {
            throw new IOException(w2.c.b("missing ledger seed asset: ", str), e10);
        }
    }
}

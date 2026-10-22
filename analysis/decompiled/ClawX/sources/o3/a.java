package o3;

import a4.j;
import androidx.emoji2.text.r;
import b5.a0;
import f4.f;
import f5.c;
import j0.m;
import java.net.HttpURLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.JsonBuilder;
import org.bouncycastle.asn1.BERTags;
import p5.l;
import t3.d;
import x3.g;
import z3.k;
import z3.o;
import z3.x0;
import z7.b;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4305a;

    public /* synthetic */ a(int i8) {
        this.f4305a = i8;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f4305a;
        int i9 = 2;
        int i10 = 3;
        c cVar = null;
        a0 a0Var = a0.f883a;
        switch (i8) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                JsonBuilder Json = (JsonBuilder) obj;
                p.e(Json, "$this$Json");
                Json.setEncodeDefaults(true);
                Json.setLenient(true);
                Json.setAllowSpecialFloatingPointValues(true);
                Json.setAllowStructuredMapKeys(true);
                Json.setPrettyPrint(false);
                Json.setUseArrayPolymorphism(false);
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case BERTags.EMBEDDED_PDV /* 11 */:
                break;
            case 12:
                Map.Entry DelegatingMutableSet = (Map.Entry) obj;
                p.e(DelegatingMutableSet, "$this$DelegatingMutableSet");
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                Map.Entry DelegatingMutableSet2 = (Map.Entry) obj;
                p.e(DelegatingMutableSet2, "$this$DelegatingMutableSet");
                break;
            case BERTags.TIME /* 14 */:
                r4.c DelegatingMutableSet3 = (r4.c) obj;
                p.e(DelegatingMutableSet3, "$this$DelegatingMutableSet");
                break;
            case 15:
                String DelegatingMutableSet4 = (String) obj;
                p.e(DelegatingMutableSet4, "$this$DelegatingMutableSet");
                break;
            case 16:
                t3.c install = (t3.c) obj;
                p.e(install, "$this$install");
                b bVar = k.f6469a;
                install.f5570e.f(f.f2606j, new j(i10, cVar, i10));
                h4.b bVar2 = install.f5571f;
                r rVar = h4.b.f3014k;
                bVar2.f(rVar, new z3.j(install, null));
                bVar2.f(rVar, new j(i10, cVar, 4));
                break;
            case 17:
                p.e((g) obj, "<this>");
                break;
            case BERTags.NUMERIC_STRING /* 18 */:
                p.e(obj, "<this>");
                break;
            case 19:
                HttpsURLConnection it = (HttpsURLConnection) obj;
                p.e(it, "it");
                break;
            case 20:
                p.e((HttpURLConnection) obj, "<this>");
                break;
            case BERTags.VIDEOTEX_STRING /* 21 */:
                break;
            case BERTags.IA5_STRING /* 22 */:
                break;
            case BERTags.UTC_TIME /* 23 */:
                char cCharValue = ((Character) obj).charValue();
                if (cCharValue != 'T' && cCharValue != 't') {
                    z = false;
                }
                break;
            case 24:
                break;
            case BERTags.GRAPHIC_STRING /* 25 */:
                break;
            case BERTags.VISIBLE_STRING /* 26 */:
                char cCharValue2 = ((Character) obj).charValue();
                break;
            case BERTags.GENERAL_STRING /* 27 */:
                a4.c createClientPlugin = (a4.c) obj;
                p.e(createClientPlugin, "$this$createClientPlugin");
                createClientPlugin.a(z3.a.f6411c, new z3.c(3, null));
                createClientPlugin.a(z3.a.f6410b, new m(i9, cVar, i9));
                break;
            case BERTags.UNIVERSAL_STRING /* 28 */:
                o HttpResponseValidator = (o) obj;
                p.e(HttpResponseValidator, "$this$HttpResponseValidator");
                HttpResponseValidator.f6488c = false;
                HttpResponseValidator.f6486a.add(new z3.f(2, null));
                break;
            default:
                a4.c createClientPlugin2 = (a4.c) obj;
                p.e(createClientPlugin2, "$this$createClientPlugin");
                ((x0) createClientPlugin2.f93b).getClass();
                createClientPlugin2.f92a.f5573h.f(h4.b.f3010g, new j(i10, cVar, 5));
                break;
        }
        return a0Var;
    }

    public /* synthetic */ a(d dVar) {
        this.f4305a = 28;
    }
}

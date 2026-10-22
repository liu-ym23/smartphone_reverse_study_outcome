package kotlinx.serialization.json.internal;

import Y8.a;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.C4847a;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import qb.C5168A;
import qb.C5172b;
import qb.D;
import qb.F;
import qb.JsonConfiguration;
import qb.i;
import qb.w;
import rb.C5252b;
import rb.C5268s;
import rb.JsonReader;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ \u0010\u000e\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\fH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "Lqb/f;", "configuration", "Lrb/a;", "lexer", "<init>", "(Lqb/f;Lrb/a;)V", "Lqb/i;", "e", "()Lqb/i;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/b;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LY8/b;Le9/c;)Ljava/lang/Object;", "f", "", "isString", "Lqb/F;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Z)Lqb/F;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "Lrb/a;", Const.INTENT_KEY_PKGNAME, "Z", "isLenient", "c", "trailingCommaAllowed", "", Const.INTENT_KEY_UMID, "I", "stackDepth", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JsonTreeReader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final JsonReader lexer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isLenient;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean trailingCommaAllowed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int stackDepth;

    public JsonTreeReader(JsonConfiguration configuration, JsonReader lexer) {
        p.i(configuration, "configuration");
        p.i(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.getIsLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    public final i e() {
        byte bF = this.lexer.F();
        if (bF == 1) {
            return j(true);
        }
        if (bF == 0) {
            return j(false);
        }
        if (bF == 6) {
            int i10 = this.stackDepth + 1;
            this.stackDepth = i10;
            this.stackDepth--;
            return i10 == 200 ? g() : i();
        }
        if (bF == 8) {
            return f();
        }
        JsonReader.z(this.lexer, "Cannot read Json element because of unexpected " + C5252b.c(bF), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final i f() {
        byte bK = this.lexer.k();
        if (this.lexer.F() == 4) {
            JsonReader.z(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.f()) {
            arrayList.add(e());
            bK = this.lexer.k();
            if (bK != 4) {
                JsonReader jsonReader = this.lexer;
                boolean z10 = bK == 9;
                int i10 = jsonReader.currentPosition;
                if (!z10) {
                    JsonReader.z(jsonReader, "Expected end of the array or comma", i10, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bK == 8) {
            this.lexer.l((byte) 9);
        } else if (bK == 4) {
            if (!this.trailingCommaAllowed) {
                C5268s.g(this.lexer, "array");
                throw new KotlinNothingValueException();
            }
            this.lexer.l((byte) 9);
        }
        return new C5172b(arrayList);
    }

    public final i g() {
        return (i) C4847a.b(new a(new JsonTreeReader$readDeepRecursive$1(this, null)), t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a6 -> B:27:0x00ac). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(Y8.b<Y8.t, qb.i> r21, e9.InterfaceC4014c<? super qb.i> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeReader.h(Y8.b, e9.c):java.lang.Object");
    }

    public final i i() {
        byte bL = this.lexer.l((byte) 6);
        if (this.lexer.F() == 4) {
            JsonReader.z(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.f()) {
                break;
            }
            String strS = this.isLenient ? this.lexer.s() : this.lexer.q();
            this.lexer.l((byte) 5);
            linkedHashMap.put(strS, e());
            bL = this.lexer.k();
            if (bL != 4) {
                if (bL != 7) {
                    JsonReader.z(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bL == 6) {
            this.lexer.l((byte) 7);
        } else if (bL == 4) {
            if (!this.trailingCommaAllowed) {
                C5268s.h(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.l((byte) 7);
        }
        return new D(linkedHashMap);
    }

    public final F j(boolean isString) {
        String strS = (this.isLenient || !isString) ? this.lexer.s() : this.lexer.q();
        return (isString || !p.d(strS, "null")) ? new w(strS, isString, null, 4, null) : C5168A.INSTANCE;
    }
}

package a3;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h extends g {

    /* renamed from: d, reason: collision with root package name */
    public final JsonParser[] f21d;

    /* renamed from: e, reason: collision with root package name */
    public int f22e;
    public boolean h;

    public h(JsonParser[] jsonParserArr) {
        this.f20c = jsonParserArr[0];
        this.h = false;
        this.f21d = jsonParserArr;
        this.f22e = 1;
    }

    public static h x1(p.a aVar, JsonParser jsonParser) {
        if (!(jsonParser instanceof h)) {
            return new h(new JsonParser[]{aVar, jsonParser});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        if (jsonParser instanceof h) {
            ((h) jsonParser).w1(arrayList);
        } else {
            arrayList.add(jsonParser);
        }
        return new h((JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        while (true) {
            this.f20c.close();
            int i10 = this.f22e;
            JsonParser[] jsonParserArr = this.f21d;
            if (i10 >= jsonParserArr.length) {
                return;
            }
            this.f22e = i10 + 1;
            this.f20c = jsonParserArr[i10];
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonToken q1() {
        JsonToken jsonTokenQ1;
        JsonParser jsonParser = this.f20c;
        if (jsonParser == null) {
            return null;
        }
        if (this.h) {
            this.h = false;
            return jsonParser.K();
        }
        JsonToken jsonTokenQ12 = jsonParser.q1();
        if (jsonTokenQ12 != null) {
            return jsonTokenQ12;
        }
        do {
            int i10 = this.f22e;
            JsonParser[] jsonParserArr = this.f21d;
            if (i10 >= jsonParserArr.length) {
                return null;
            }
            this.f22e = i10 + 1;
            JsonParser jsonParser2 = jsonParserArr[i10];
            this.f20c = jsonParser2;
            jsonTokenQ1 = jsonParser2.q1();
        } while (jsonTokenQ1 == null);
        return jsonTokenQ1;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final JsonParser v1() {
        if (this.f20c.K() == JsonToken.START_OBJECT || this.f20c.K() == JsonToken.START_ARRAY) {
            int i10 = 1;
            while (true) {
                JsonToken jsonTokenQ1 = q1();
                if (jsonTokenQ1 == null) {
                    break;
                }
                if (!jsonTokenQ1.f3598e) {
                    if (jsonTokenQ1.h && i10 - 1 == 0) {
                        break;
                    }
                } else {
                    i10++;
                }
            }
        }
        return this;
    }

    public final void w1(ArrayList arrayList) {
        JsonParser[] jsonParserArr = this.f21d;
        int length = jsonParserArr.length;
        for (int i10 = this.f22e - 1; i10 < length; i10++) {
            JsonParser jsonParser = jsonParserArr[i10];
            if (jsonParser instanceof h) {
                ((h) jsonParser).w1(arrayList);
            } else {
                arrayList.add(jsonParser);
            }
        }
    }
}

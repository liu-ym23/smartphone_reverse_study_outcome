package ra;

import F9.AbstractC0226d;
import F9.B;
import F9.K;
import V9.f;
import V9.g;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import qa.InterfaceC1859k;

/* loaded from: classes4.dex */
public final class b implements InterfaceC1859k {
    public static final B c;

    /* renamed from: a, reason: collision with root package name */
    public final Gson f5687a;
    public final TypeAdapter b;

    static {
        Pattern pattern = B.e;
        c = AbstractC0226d.g("application/json; charset=UTF-8");
    }

    public b(Gson gson, TypeAdapter typeAdapter) {
        this.f5687a = gson;
        this.b = typeAdapter;
    }

    @Override // qa.InterfaceC1859k
    public final Object convert(Object obj) throws IOException {
        g gVar = new g();
        JsonWriter jsonWriterNewJsonWriter = this.f5687a.newJsonWriter(new OutputStreamWriter(new f(gVar), StandardCharsets.UTF_8));
        this.b.write(jsonWriterNewJsonWriter, obj);
        jsonWriterNewJsonWriter.close();
        return K.create(c, gVar.v(gVar.b));
    }
}

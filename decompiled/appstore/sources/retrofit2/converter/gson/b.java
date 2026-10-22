package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Converter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaType f24021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f24022d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f24023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f24024b;

    static {
        f24021c = MediaType.c("application/json; charset=UTF-8");
        f24022d = Charset.forName("UTF-8");
    }

    public b(Gson r10, TypeAdapter r11) {
        this.f24023a = r10;
        this.f24024b = r11;
    }

    public RequestBody a(Object r10) {
        Buffer r11 = new Buffer();
        OutputStreamWriter r12 = new OutputStreamWriter(r11.outputStream(), f24022d);
        JsonWriter r13 = this.f24023a.newJsonWriter(r12);
        this.f24024b.write(r13, r10);
        r13.close();
        return RequestBody.d(f24021c, r11.readByteString());
    }

    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ Object convert(Object r10) {
        return a(r10);
    }
}

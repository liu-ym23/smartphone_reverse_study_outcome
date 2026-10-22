package x4;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import h6.f;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Converter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f25425c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f25426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f25427b;

    static {
        f25425c = Charset.forName("UTF-8");
    }

    public b(Gson r10, TypeAdapter r11) {
        this.f25426a = r10;
        this.f25427b = r11;
    }

    public TypedOutput a(Object r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r12 = new OutputStreamWriter(r11, f25425c);
        JsonWriter r13 = this.f25426a.newJsonWriter(r12);
        this.f25427b.write(r13, r10);
        r13.close();
        return new f("application/json; charset=UTF-8", r11.toByteArray(), new String[0]);
    }

    @Override // com.bytedance.retrofit2.Converter
    public /* bridge */ /* synthetic */ Object convert(Object r10) {
        return a(r10);
    }
}

package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f24025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f24026b;

    public c(Gson r10, TypeAdapter r11) {
        this.f24025a = r10;
        this.f24026b = r11;
    }

    public Object a(ResponseBody r10) {
        JsonReader r11 = this.f24025a.newJsonReader(r10.charStream());
        Object r12 = this.f24026b.read(r11);     // Catch: Throwable -> L6
        r10.close();
        return r12;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    }

    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ Object convert(Object r10) {
        return a((ResponseBody) r10);
    }
}

package x4;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import h6.d;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f25428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter f25429b;

    public c(Gson r10, TypeAdapter r11) {
        this.f25428a = r10;
        this.f25429b = r11;
    }

    public Object a(TypedInput r10) {
        String r11 = "UTF-8";
        if (r10.mimeType() == null) goto L5;
        r11 = d.a(r10.mimeType(), "UTF-8");
    L5:
        InputStreamReader r12 = new InputStreamReader(r10.in(), r11);
        JsonReader r13 = this.f25428a.newJsonReader(r12);
        Object r14 = this.f25429b.read(r13);     // Catch: Throwable -> L9
        r12.close();     // Catch: IOException -> L12
    L8:
        return r14;
    L9:
        th = move-exception;
        r12.close();     // Catch: IOException -> L13
    L11:
        throw th;
    }

    @Override // com.bytedance.retrofit2.Converter
    public /* bridge */ /* synthetic */ Object convert(Object r10) {
        return a((TypedInput) r10);
    }
}

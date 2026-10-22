package retrofit2.converter.gson;

import F1.A;
import F1.n;
import S.r;
import com.google.gson.stream.JsonWriter;
import com.stepos.activeview.utils.Constants;
import h3.C0611u;
import h3.M;
import h3.Z;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import k3.C0694i;
import retrofit2.Converter;

/* loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, Z> {
    private static final M MEDIA_TYPE;
    private static final Charset UTF_8;
    private final A adapter;
    private final n gson;

    static {
        Pattern pattern = M.f12732d;
        MEDIA_TYPE = C0611u.o("application/json; charset=UTF-8");
        UTF_8 = Charset.forName(Constants.UTF_8_CODE);
    }

    public GsonRequestBodyConverter(n nVar, A a4) {
        this.gson = nVar;
        this.adapter = a4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ Z convert(Object obj) throws IOException {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // retrofit2.Converter
    public Z convert(T t4) throws IOException {
        C0694i c0694i = new C0694i();
        JsonWriter jsonWriterF = this.gson.f(new OutputStreamWriter(new r(c0694i), UTF_8));
        this.adapter.c(jsonWriterF, t4);
        jsonWriterF.close();
        return Z.create(MEDIA_TYPE, c0694i.i(c0694i.f13357b));
    }
}

package N;

import androidx.datastore.preferences.protobuf.B;
import j4.k;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4170a = new a(null);

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final f a(InputStream inputStream) throws L.a {
            k.g(inputStream, "input");
            try {
                f fVarR = f.R(inputStream);
                k.f(fVarR, "{\n                PreferencesProto.PreferenceMap.parseFrom(input)\n            }");
                return fVarR;
            } catch (B e6) {
                throw new L.a("Unable to parse preferences proto.", e6);
            }
        }

        private a() {
        }
    }
}

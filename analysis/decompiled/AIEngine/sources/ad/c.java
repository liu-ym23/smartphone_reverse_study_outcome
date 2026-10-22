package ad;

import java.io.IOException;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c {
    void onFailure(b bVar, IOException iOException);

    void onResponse(b bVar, Response response);
}

package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public interface Callback {
    void onFailure(Call r10, IOException r11);

    void onResponse(Call r10, Response r11) throws IOException;
}

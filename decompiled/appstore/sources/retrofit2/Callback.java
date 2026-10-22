package retrofit2;

/* JADX INFO: loaded from: classes4.dex */
public interface Callback<T> {
    void onFailure(Call<T> r10, Throwable r11);

    void onResponse(Call<T> r10, Response<T> r11);
}

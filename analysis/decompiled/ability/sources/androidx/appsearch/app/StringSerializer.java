package androidx.appsearch.app;

/* loaded from: classes.dex */
public interface StringSerializer<T> {
    T deserialize(String str);

    String serialize(T t9);
}

package com.squareup.moshi.internal;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class NullSafeJsonAdapter<T> extends JsonAdapter<T> {
    private final JsonAdapter<T> delegate;

    public NullSafeJsonAdapter(JsonAdapter<T> jsonAdapter) {
        this.delegate = jsonAdapter;
    }

    public JsonAdapter<T> delegate() {
        return this.delegate;
    }

    @Override // com.squareup.moshi.JsonAdapter
    @Nullable
    public T fromJson(JsonReader jsonReader) {
        return jsonReader.peek() == JsonReader.Token.NULL ? (T) jsonReader.nextNull() : this.delegate.fromJson(jsonReader);
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter jsonWriter, @Nullable T t2) {
        if (t2 == null) {
            jsonWriter.nullValue();
        } else {
            this.delegate.toJson(jsonWriter, (JsonWriter) t2);
        }
    }

    public String toString() {
        return this.delegate + ".nullSafe()";
    }
}

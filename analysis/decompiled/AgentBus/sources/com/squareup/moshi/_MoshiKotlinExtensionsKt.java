package com.squareup.moshi;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.NonNullJsonAdapter;
import com.squareup.moshi.internal.NullSafeJsonAdapter;
import kotlin.Metadata;
import q7.k;
import w7.e0;
import w7.u;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\n¨\u0006\u000b"}, d2 = {"T", "Lcom/squareup/moshi/Moshi;", "Lcom/squareup/moshi/JsonAdapter;", "adapter", "(Lcom/squareup/moshi/Moshi;)Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi$Builder;", "addAdapter", "(Lcom/squareup/moshi/Moshi$Builder;Lcom/squareup/moshi/JsonAdapter;)Lcom/squareup/moshi/Moshi$Builder;", "Lw7/u;", "ktype", "(Lcom/squareup/moshi/Moshi;Lw7/u;)Lcom/squareup/moshi/JsonAdapter;", "moshi"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class _MoshiKotlinExtensionsKt {
    public static final <T> JsonAdapter<T> adapter(Moshi moshi, u uVar) {
        k.e(moshi, "<this>");
        k.e(uVar, "ktype");
        JsonAdapter<T> jsonAdapterAdapter = moshi.adapter(e0.C(uVar));
        if ((jsonAdapterAdapter instanceof NullSafeJsonAdapter) || (jsonAdapterAdapter instanceof NonNullJsonAdapter)) {
            return jsonAdapterAdapter;
        }
        if (uVar.p()) {
            JsonAdapter<T> jsonAdapterNullSafe = jsonAdapterAdapter.nullSafe();
            k.d(jsonAdapterNullSafe, "{\n    adapter.nullSafe()\n  }");
            return jsonAdapterNullSafe;
        }
        JsonAdapter<T> jsonAdapterNonNull = jsonAdapterAdapter.nonNull();
        k.d(jsonAdapterNonNull, "{\n    adapter.nonNull()\n  }");
        return jsonAdapterNonNull;
    }

    public static final <T> Moshi.Builder addAdapter(Moshi.Builder builder, JsonAdapter<T> jsonAdapter) {
        k.e(builder, "<this>");
        k.e(jsonAdapter, "adapter");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final <T> JsonAdapter<T> adapter(Moshi moshi) {
        k.e(moshi, "<this>");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }
}

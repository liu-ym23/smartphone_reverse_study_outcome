package com.stepos.core.ability.converter;

import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.g;
import v6.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface InferenceInputConverter {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ c convert$default(InferenceInputConverter inferenceInputConverter, Content content, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
            }
            if ((i10 & 2) != 0) {
                str = "";
            }
            return inferenceInputConverter.convert(content, str);
        }

        public static void releaseTransient(InferenceInputConverter inferenceInputConverter, String requestId) {
            g.f(requestId, "requestId");
        }
    }

    c convert(Content content, String str);

    void releaseTransient(String str);
}

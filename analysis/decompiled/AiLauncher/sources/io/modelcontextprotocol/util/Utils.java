package io.modelcontextprotocol.util;

import java.net.URI;
import java.util.Collection;
import java.util.Map;
import reactor.util.annotation.Nullable;

/* loaded from: classes4.dex */
public final class Utils {
    public static boolean hasText(@Nullable String str) {
        return (str == null || str.isBlank()) ? false : true;
    }

    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    private static boolean isUnderBaseUri(URI uri, URI uri2) {
        if (!uri.getScheme().equals(uri2.getScheme()) || !uri.getAuthority().equals(uri2.getAuthority())) {
            return false;
        }
        URI uriNormalize = uri.normalize();
        URI uriNormalize2 = uri2.normalize();
        String path = uriNormalize.getPath();
        String path2 = uriNormalize2.getPath();
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        return path2.startsWith(path);
    }

    public static URI resolveUri(URI uri, String str) {
        if (!hasText(str)) {
            return uri;
        }
        URI uriCreate = URI.create(str);
        if (!uriCreate.isAbsolute() || isUnderBaseUri(uri, uriCreate)) {
            return uri.resolve(uriCreate);
        }
        throw new IllegalArgumentException("Absolute endpoint URL does not match the base URL.");
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}

package io.modelcontextprotocol.util;

import g5.f;
import java.net.URI;
import java.util.Collection;
import java.util.Map;
import reactor.util.annotation.Nullable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
        f.s("Absolute endpoint URL does not match the base URL.");
        return null;
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}

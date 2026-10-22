package x3;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class h implements d {
    public static final Pattern b = Pattern.compile("([A-Za-z0-9+-\\.]*:)?//|[A-Za-z0-9+-\\.]+:");

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6878a;

    @Override // x3.d
    public final String a() {
        switch (this.f6878a) {
            case 0:
                return "format.iri";
            case 1:
                return "format.iri-reference";
            case 2:
                return "format.uri";
            default:
                return "format.uri-reference";
        }
    }

    public final boolean c(URI uri) {
        String rawQuery;
        String rawQuery2;
        boolean zAllMatch;
        String rawQuery3;
        switch (this.f6878a) {
            case 0:
                boolean zIsAbsolute = uri.isAbsolute();
                if (zIsAbsolute) {
                    String authority = uri.getAuthority();
                    if (authority == null || !f.f6876a.matcher(authority).matches()) {
                        String rawQuery4 = uri.getRawQuery();
                        if (rawQuery4 != null) {
                            if (rawQuery4.indexOf(91) != -1 || rawQuery4.indexOf(93) != -1) {
                            }
                        }
                    }
                }
                break;
            case 1:
                String authority2 = uri.getAuthority();
                if ((authority2 == null || !f.f6876a.matcher(authority2).matches()) && ((rawQuery = uri.getRawQuery()) == null || (rawQuery.indexOf(91) == -1 && rawQuery.indexOf(93) == -1))) {
                }
                break;
            case 2:
                boolean zIsAbsolute2 = uri.isAbsolute();
                if (zIsAbsolute2) {
                    boolean zAllMatch2 = uri.toString().codePoints().allMatch(new A3.c(6));
                    if (zAllMatch2 && (rawQuery2 = uri.getRawQuery()) != null) {
                        if (rawQuery2.indexOf(91) != -1 || rawQuery2.indexOf(93) != -1) {
                        }
                    }
                }
                break;
            default:
                zAllMatch = uri.toString().codePoints().allMatch(new A3.c(7));
                if (zAllMatch && (rawQuery3 = uri.getRawQuery()) != null) {
                    if (rawQuery3.indexOf(91) != -1 || rawQuery3.indexOf(93) != -1) {
                    }
                }
                break;
        }
        return zAllMatch;
    }

    @Override // x3.d
    public final String getName() {
        switch (this.f6878a) {
            case 0:
                return "iri";
            case 1:
                return "iri-reference";
            case 2:
                return "uri";
            default:
                return "uri-reference";
        }
    }

    @Override // x3.d
    public final boolean matches(String str) {
        try {
            return c(new URI(str));
        } catch (URISyntaxException e) {
            return b.matcher(e.getInput()).matches();
        }
    }
}

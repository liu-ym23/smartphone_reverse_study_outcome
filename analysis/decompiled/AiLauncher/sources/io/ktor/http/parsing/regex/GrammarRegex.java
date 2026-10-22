package io.ktor.http.parsing.regex;

import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/http/parsing/regex/GrammarRegex;", "", "", "regexRaw", "", "groupsCountRaw", "", "group", "<init>", "(Ljava/lang/String;IZ)V", "regex", "Ljava/lang/String;", "getRegex", "()Ljava/lang/String;", "groupsCount", "I", "getGroupsCount", "()I", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class GrammarRegex {
    private final int groupsCount;
    private final String regex;

    public GrammarRegex(String regexRaw, int i10, boolean z10) {
        p.i(regexRaw, "regexRaw");
        if (z10) {
            regexRaw = '(' + regexRaw + ')';
        }
        this.regex = regexRaw;
        this.groupsCount = z10 ? i10 + 1 : i10;
    }

    public final int getGroupsCount() {
        return this.groupsCount;
    }

    public final String getRegex() {
        return this.regex;
    }

    public /* synthetic */ GrammarRegex(String str, int i10, boolean z10, int i11, i iVar) {
        this(str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? false : z10);
    }
}

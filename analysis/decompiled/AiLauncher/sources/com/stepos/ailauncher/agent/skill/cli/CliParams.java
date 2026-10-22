package com.stepos.ailauncher.agent.skill.cli;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/CliParams;", "Ljava/io/Serializable;", "", "keyword", "", "statusIn", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyword", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CliParams implements Serializable {
    private final String keyword;
    private final List<String> statusIn;

    /* JADX WARN: Multi-variable type inference failed */
    public CliParams() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<String> a() {
        return this.statusIn;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CliParams)) {
            return false;
        }
        CliParams cliParams = (CliParams) other;
        return p.d(this.keyword, cliParams.keyword) && p.d(this.statusIn, cliParams.statusIn);
    }

    public int hashCode() {
        String str = this.keyword;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.statusIn.hashCode();
    }

    public String toString() {
        return "CliParams(keyword=" + this.keyword + ", statusIn=" + this.statusIn + ")";
    }

    public CliParams(String str, List<String> statusIn) {
        p.i(statusIn, "statusIn");
        this.keyword = str;
        this.statusIn = statusIn;
    }

    public /* synthetic */ CliParams(String str, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? C1173v.m() : list);
    }
}

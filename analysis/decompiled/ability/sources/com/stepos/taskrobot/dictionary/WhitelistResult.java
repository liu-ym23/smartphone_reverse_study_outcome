package com.stepos.taskrobot.dictionary;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.dictionary.model.DictionaryItem;
import com.stepos.taskrobot.dictionary.model.RedirectGroup;
import com.stepos.taskrobot.dictionary.model.WhitelistApp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/stepos/taskrobot/dictionary/WhitelistResult;", "", "rawItem", "Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "apps", "", "Lcom/stepos/taskrobot/dictionary/model/WhitelistApp;", "redirectGroups", "Lcom/stepos/taskrobot/dictionary/model/RedirectGroup;", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;Ljava/util/List;Ljava/util/List;)V", "getRawItem", "()Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "getApps", "()Ljava/util/List;", "getRedirectGroups", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WhitelistResult {
    private final List<WhitelistApp> apps;
    private final DictionaryItem rawItem;
    private final List<RedirectGroup> redirectGroups;

    public WhitelistResult(DictionaryItem dictionaryItem, List list, List list2, int i, e eVar) {
        this(dictionaryItem, list, (i & 4) != 0 ? EmptyList.f4893a : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistResult copy$default(WhitelistResult whitelistResult, DictionaryItem dictionaryItem, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            dictionaryItem = whitelistResult.rawItem;
        }
        if ((i & 2) != 0) {
            list = whitelistResult.apps;
        }
        if ((i & 4) != 0) {
            list2 = whitelistResult.redirectGroups;
        }
        return whitelistResult.copy(dictionaryItem, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final DictionaryItem getRawItem() {
        return this.rawItem;
    }

    public final List<WhitelistApp> component2() {
        return this.apps;
    }

    public final List<RedirectGroup> component3() {
        return this.redirectGroups;
    }

    public final WhitelistResult copy(DictionaryItem rawItem, List<WhitelistApp> apps, List<RedirectGroup> redirectGroups) {
        k.f(apps, "apps");
        k.f(redirectGroups, "redirectGroups");
        return new WhitelistResult(rawItem, apps, redirectGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitelistResult)) {
            return false;
        }
        WhitelistResult whitelistResult = (WhitelistResult) other;
        return k.b(this.rawItem, whitelistResult.rawItem) && k.b(this.apps, whitelistResult.apps) && k.b(this.redirectGroups, whitelistResult.redirectGroups);
    }

    public final List<WhitelistApp> getApps() {
        return this.apps;
    }

    public final DictionaryItem getRawItem() {
        return this.rawItem;
    }

    public final List<RedirectGroup> getRedirectGroups() {
        return this.redirectGroups;
    }

    public int hashCode() {
        DictionaryItem dictionaryItem = this.rawItem;
        return this.redirectGroups.hashCode() + a.e(this.apps, (dictionaryItem == null ? 0 : dictionaryItem.hashCode()) * 31, 31);
    }

    public String toString() {
        DictionaryItem dictionaryItem = this.rawItem;
        List<WhitelistApp> list = this.apps;
        List<RedirectGroup> list2 = this.redirectGroups;
        StringBuilder sb = new StringBuilder("WhitelistResult(rawItem=");
        sb.append(dictionaryItem);
        sb.append(", apps=");
        sb.append(list);
        sb.append(", redirectGroups=");
        return a.q(sb, list2, ")");
    }

    public WhitelistResult(DictionaryItem dictionaryItem, List<WhitelistApp> apps, List<RedirectGroup> redirectGroups) {
        k.f(apps, "apps");
        k.f(redirectGroups, "redirectGroups");
        this.rawItem = dictionaryItem;
        this.apps = apps;
        this.redirectGroups = redirectGroups;
    }
}

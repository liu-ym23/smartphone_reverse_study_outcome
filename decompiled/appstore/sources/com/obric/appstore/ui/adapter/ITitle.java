package com.obric.appstore.ui.adapter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/appstore/ui/adapter/ITitle;", "", "showTopDivider", "", "getShowTopDivider", "()Z", "title", "", "getTitle", "()Ljava/lang/String;", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ITitle {

    public static final class a {
        public static String a(ITitle r10) {
            return "";
        }
    }

    boolean getShowTopDivider();

    @NotNull
    String getTitle();
}

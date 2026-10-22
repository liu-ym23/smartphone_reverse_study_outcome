package androidx.appsearch.ast;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import java.util.Collections;
import java.util.List;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
/* loaded from: classes.dex */
public interface Node {
    default List<Node> getChildren() {
        return Collections.EMPTY_LIST;
    }
}

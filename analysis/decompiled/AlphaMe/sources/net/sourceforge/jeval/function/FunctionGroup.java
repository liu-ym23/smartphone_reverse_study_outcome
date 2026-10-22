package net.sourceforge.jeval.function;

import java.util.List;
import net.sourceforge.jeval.Evaluator;

/* loaded from: classes2.dex */
public interface FunctionGroup {
    List getFunctions();

    String getName();

    void load(Evaluator evaluator);

    void unload(Evaluator evaluator);
}

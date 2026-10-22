package net.sourceforge.jeval.judge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionGroup;

/* loaded from: classes2.dex */
public class JudgeFunctions implements FunctionGroup {
    private List functions;

    public JudgeFunctions() {
        ArrayList arrayList = new ArrayList();
        this.functions = arrayList;
        arrayList.add(new net.sourceforge.jeval.function.judge.Eq());
        this.functions.add(new net.sourceforge.jeval.function.judge.Ge());
        this.functions.add(new net.sourceforge.jeval.function.judge.Gt());
        this.functions.add(new net.sourceforge.jeval.function.judge.Le());
        this.functions.add(new net.sourceforge.jeval.function.judge.Lt());
        this.functions.add(new net.sourceforge.jeval.function.judge.Ne());
        this.functions.add(new net.sourceforge.jeval.function.judge.IsNull());
        this.functions.add(new net.sourceforge.jeval.function.judge.IfElse());
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public List getFunctions() {
        return this.functions;
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public String getName() {
        return "judgeFunctions";
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public void load(Evaluator evaluator) throws IllegalArgumentException {
        Iterator it = this.functions.iterator();
        while (it.hasNext()) {
            evaluator.putFunction((Function) it.next());
        }
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public void unload(Evaluator evaluator) {
        Iterator it = this.functions.iterator();
        while (it.hasNext()) {
            evaluator.removeFunction(((Function) it.next()).getName());
        }
    }
}

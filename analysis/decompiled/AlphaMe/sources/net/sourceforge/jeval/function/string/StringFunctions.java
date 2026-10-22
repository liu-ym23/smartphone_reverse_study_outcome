package net.sourceforge.jeval.function.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionGroup;

/* loaded from: classes2.dex */
public class StringFunctions implements FunctionGroup {
    private List functions;

    public StringFunctions() {
        ArrayList arrayList = new ArrayList();
        this.functions = arrayList;
        arrayList.add(new CharAt());
        this.functions.add(new CompareTo());
        this.functions.add(new CompareToIgnoreCase());
        this.functions.add(new Concat());
        this.functions.add(new EndsWith());
        this.functions.add(new Equals());
        this.functions.add(new EqualsIgnoreCase());
        this.functions.add(new Eval());
        this.functions.add(new IndexOf());
        this.functions.add(new LastIndexOf());
        this.functions.add(new Length());
        this.functions.add(new Replace());
        this.functions.add(new StartsWith());
        this.functions.add(new Substring());
        this.functions.add(new ToLowerCase());
        this.functions.add(new ToUpperCase());
        this.functions.add(new Trim());
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public List getFunctions() {
        return this.functions;
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public String getName() {
        return "stringFunctions";
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

package net.sourceforge.jeval.string;

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
        arrayList.add(new net.sourceforge.jeval.function.string.CharAt());
        this.functions.add(new net.sourceforge.jeval.function.string.CompareTo());
        this.functions.add(new CompareToIgnoreCase());
        this.functions.add(new net.sourceforge.jeval.function.string.Concat());
        this.functions.add(new net.sourceforge.jeval.function.string.EndsWith());
        this.functions.add(new net.sourceforge.jeval.function.string.Equals());
        this.functions.add(new EqualsIgnoreCase());
        this.functions.add(new net.sourceforge.jeval.function.string.Eval());
        this.functions.add(new net.sourceforge.jeval.function.string.IndexOf());
        this.functions.add(new net.sourceforge.jeval.function.string.LastIndexOf());
        this.functions.add(new net.sourceforge.jeval.function.string.Length());
        this.functions.add(new net.sourceforge.jeval.function.string.Replace());
        this.functions.add(new net.sourceforge.jeval.function.string.StartsWith());
        this.functions.add(new net.sourceforge.jeval.function.string.Substring());
        this.functions.add(new net.sourceforge.jeval.function.string.ToLowerCase());
        this.functions.add(new net.sourceforge.jeval.function.string.ToUpperCase());
        this.functions.add(new net.sourceforge.jeval.function.string.Trim());
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

package net.sourceforge.jeval.function.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionGroup;

/* loaded from: classes2.dex */
public class MathFunctions implements FunctionGroup {
    private List functions;

    public MathFunctions() {
        ArrayList arrayList = new ArrayList();
        this.functions = arrayList;
        arrayList.add(new Abs());
        this.functions.add(new Acos());
        this.functions.add(new Asin());
        this.functions.add(new Atan());
        this.functions.add(new Atan2());
        this.functions.add(new Ceil());
        this.functions.add(new Cos());
        this.functions.add(new Exp());
        this.functions.add(new Floor());
        this.functions.add(new IEEEremainder());
        this.functions.add(new Log());
        this.functions.add(new Max());
        this.functions.add(new Min());
        this.functions.add(new Pow());
        this.functions.add(new Random());
        this.functions.add(new Rint());
        this.functions.add(new Round());
        this.functions.add(new Sin());
        this.functions.add(new Sqrt());
        this.functions.add(new Tan());
        this.functions.add(new ToDegrees());
        this.functions.add(new ToRadians());
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public List getFunctions() {
        return this.functions;
    }

    @Override // net.sourceforge.jeval.function.FunctionGroup
    public String getName() {
        return "numberFunctions";
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

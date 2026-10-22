package net.sourceforge.jeval.math;

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
        arrayList.add(new net.sourceforge.jeval.function.math.Abs());
        this.functions.add(new net.sourceforge.jeval.function.math.Acos());
        this.functions.add(new net.sourceforge.jeval.function.math.Asin());
        this.functions.add(new net.sourceforge.jeval.function.math.Atan());
        this.functions.add(new net.sourceforge.jeval.function.math.Atan2());
        this.functions.add(new net.sourceforge.jeval.function.math.Ceil());
        this.functions.add(new net.sourceforge.jeval.function.math.Cos());
        this.functions.add(new net.sourceforge.jeval.function.math.Exp());
        this.functions.add(new net.sourceforge.jeval.function.math.Floor());
        this.functions.add(new net.sourceforge.jeval.function.math.IEEEremainder());
        this.functions.add(new net.sourceforge.jeval.function.math.Log());
        this.functions.add(new net.sourceforge.jeval.function.math.Max());
        this.functions.add(new net.sourceforge.jeval.function.math.Min());
        this.functions.add(new net.sourceforge.jeval.function.math.Pow());
        this.functions.add(new net.sourceforge.jeval.function.math.Random());
        this.functions.add(new net.sourceforge.jeval.function.math.Rint());
        this.functions.add(new net.sourceforge.jeval.function.math.Round());
        this.functions.add(new net.sourceforge.jeval.function.math.Sin());
        this.functions.add(new net.sourceforge.jeval.function.math.Sqrt());
        this.functions.add(new net.sourceforge.jeval.function.math.Tan());
        this.functions.add(new net.sourceforge.jeval.function.math.ToDegrees());
        this.functions.add(new net.sourceforge.jeval.function.math.ToRadians());
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

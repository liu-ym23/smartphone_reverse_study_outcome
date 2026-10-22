package com.obric.oui.constraintlayout.core;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class Metrics {
    public long additionalMeasures;
    public long bfs;
    public long constraints;
    public long determineGroups;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long graphSolved;
    public long grouping;
    public long infeasibleDetermineGroups;
    public long iterations;
    public long lastTableSize;
    public long layouts;
    public long linearSolved;
    public long mChildCount;
    public long mEquations;
    public long mMeasureCalls;
    public long mMeasureDuration;
    public int mNumberOfLayouts;
    public int mNumberOfMeasures;
    public long mSimpleEquations;
    public long mSolverPasses;
    public long mVariables;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measuredMatchWidgets;
    public long measuredWidgets;
    public long measures;
    public long measuresLayoutDuration;
    public long measuresWidgetsDuration;
    public long measuresWrap;
    public long measuresWrapInfeasible;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts;
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;
    public long widgets;

    public Metrics() {
        this.problematicLayouts = new ArrayList();
    }

    public String toString() {
        return "\n*** Metrics ***\nmeasures: " + this.measures + "\nmeasuresWrap: " + this.measuresWrap + "\nmeasuresWrapInfeasible: " + this.measuresWrapInfeasible + "\ndetermineGroups: " + this.determineGroups + "\ninfeasibleDetermineGroups: " + this.infeasibleDetermineGroups + "\ngraphOptimizer: " + this.graphOptimizer + "\nwidgets: " + this.widgets + "\ngraphSolved: " + this.graphSolved + "\nlinearSolved: " + this.linearSolved + "\n";
    }

    public void reset() {
        this.measures = 0;
        this.widgets = 0;
        this.additionalMeasures = 0;
        this.resolutions = 0;
        this.tableSizeIncrease = 0;
        this.maxTableSize = 0;
        this.lastTableSize = 0;
        this.maxVariables = 0;
        this.maxRows = 0;
        this.minimize = 0;
        this.minimizeGoal = 0;
        this.constraints = 0;
        this.simpleconstraints = 0;
        this.optimize = 0;
        this.iterations = 0;
        this.pivots = 0;
        this.bfs = 0;
        this.variables = 0;
        this.errors = 0;
        this.slackvariables = 0;
        this.extravariables = 0;
        this.fullySolved = 0;
        this.graphOptimizer = 0;
        this.graphSolved = 0;
        this.resolvedWidgets = 0;
        this.nonresolvedWidgets = 0;
        this.linearSolved = 0;
        this.problematicLayouts.clear();
        this.mNumberOfMeasures = 0;
        this.mNumberOfLayouts = 0;
        this.measuresWidgetsDuration = 0;
        this.measuresLayoutDuration = 0;
        this.mChildCount = 0;
        this.mMeasureDuration = 0;
        this.mMeasureCalls = 0;
        this.mSolverPasses = 0;
        this.mVariables = 0;
        this.mEquations = 0;
        this.mSimpleEquations = 0;
    }

    public void copy(Metrics r3) {
        this.mVariables = r3.mVariables;
        this.mEquations = r3.mEquations;
        this.mSimpleEquations = r3.mSimpleEquations;
        this.mNumberOfMeasures = r3.mNumberOfMeasures;
        this.mNumberOfLayouts = r3.mNumberOfLayouts;
        this.mMeasureDuration = r3.mMeasureDuration;
        this.mChildCount = r3.mChildCount;
        this.mMeasureCalls = r3.mMeasureCalls;
        this.measuresWidgetsDuration = r3.measuresWidgetsDuration;
        this.mSolverPasses = r3.mSolverPasses;
        this.measuresLayoutDuration = r3.measuresLayoutDuration;
        this.measures = r3.measures;
        this.widgets = r3.widgets;
        this.additionalMeasures = r3.additionalMeasures;
        this.resolutions = r3.resolutions;
        this.tableSizeIncrease = r3.tableSizeIncrease;
        this.maxTableSize = r3.maxTableSize;
        this.lastTableSize = r3.lastTableSize;
        this.maxVariables = r3.maxVariables;
        this.maxRows = r3.maxRows;
        this.minimize = r3.minimize;
        this.minimizeGoal = r3.minimizeGoal;
        this.constraints = r3.constraints;
        this.simpleconstraints = r3.simpleconstraints;
        this.optimize = r3.optimize;
        this.iterations = r3.iterations;
        this.pivots = r3.pivots;
        this.bfs = r3.bfs;
        this.variables = r3.variables;
        this.errors = r3.errors;
        this.slackvariables = r3.slackvariables;
        this.extravariables = r3.extravariables;
        this.fullySolved = r3.fullySolved;
        this.graphOptimizer = r3.graphOptimizer;
        this.graphSolved = r3.graphSolved;
        this.resolvedWidgets = r3.resolvedWidgets;
        this.nonresolvedWidgets = r3.nonresolvedWidgets;
    }
}
